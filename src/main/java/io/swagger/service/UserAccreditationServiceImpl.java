package io.swagger.service;


import io.swagger.entity.ClientUser;
import io.swagger.entity.Document;
import io.swagger.entity.UserAccreditation;
import io.swagger.enums.Status;
import io.swagger.model.*;
import io.swagger.repository.DocumentRepository;
import io.swagger.repository.UserAccreditationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserAccreditationServiceImpl implements UserAccreditationService {

    private static final Logger log = LoggerFactory.getLogger(UserAccreditationServiceImpl.class);

    @Autowired
    private UserAccreditationRepository userAccreditationRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ClientUserService clientUserService;

    @Override
    public AccreditationStatusResponse statusCreation(UserAccreditation userAccreditation) {

        log.info("Creating a new accreditation for user: {}", userAccreditation.getUser());
        UserAccreditation userAccreditationResponse = userAccreditationRepository.save(userAccreditation);

        return new AccreditationStatusResponse().accreditationId(String.valueOf(userAccreditationResponse.getAccreditation_id()));
    }

    @Override
    public UserAccreditation bodyToEntity(AccreditationStatusCreation body) {

        log.info("Mapping creation request body to DB entity");
        ClientUser user = clientUserService.findById(body.getUserId()).get();
        Document document = new Document(body.getDocument().getName(), body.getDocument().getMimeType(), body.getDocument().getContent());
        documentRepository.save(document);

        return new UserAccreditation(user, body.getAccreditationType().toString(), document, Status.PENDING.name(), Timestamp.from(Instant.now()));

    }

    @Override
    public Optional<UserAccreditation> findById(Integer id) {
        return userAccreditationRepository.findById(id);
    }

    @Override
    public AccreditationStatusResponse updateStatus(Integer accreditationId, AccreditationStatusFinalization accreditationStatusFinalization) {
        log.info("Updating status for accreditation: {}", accreditationId);
        UserAccreditation userAccreditation = findById(accreditationId).get();
        userAccreditation.setStatus(accreditationStatusFinalization.getOutcome().name());
        userAccreditation.setLastUpdate(Timestamp.from(Instant.now()));
        userAccreditationRepository.save(userAccreditation);
        return new AccreditationStatusResponse().accreditationId(String.valueOf(accreditationId));
    }

    @Override
    public Iterable<UserAccreditation> findAllByUserId(String id) {
        return userAccreditationRepository.findByClientUserId(id);
    }

    @Override
    public AccreditationStatusForUser getAllAccreditation(String userId) {

        ArrayList<UserAccreditation> accreditationList = (ArrayList<UserAccreditation>) findAllByUserId(userId);

        return accreditationsToResponse(accreditationList, userId);

    }

    private AccreditationStatusForUser accreditationsToResponse(ArrayList<UserAccreditation> list, String userId) {
        log.info("Mapping accreditation list to Api response");
        AccreditationStatus map = new AccreditationStatus();
        StatusDetails statusDetails;
        for (UserAccreditation userAccreditation : list) {
            statusDetails = new StatusDetails(userAccreditation.getAccreditationType(), userAccreditation.getStatus());
            map.put(String.valueOf(userAccreditation.getAccreditation_id()), statusDetails);
        }
        return new AccreditationStatusForUser(userId, map);
    }

    @Override
    public void updateExpiredStatus(Timestamp time) {
        List<UserAccreditation> expired = userAccreditationRepository.findByStatusAndLastUpdateBefore(Status.PENDING.name(), time);
        log.info("Found {} records to expire", expired.size());
        for (UserAccreditation userAccreditation : expired) {
            userAccreditation.setStatus(Status.EXPIRED.name());
            userAccreditationRepository.save(userAccreditation);
            log.debug("Updated status for {} to EXPIRED", userAccreditation.getAccreditation_id());
        }
    }
}
