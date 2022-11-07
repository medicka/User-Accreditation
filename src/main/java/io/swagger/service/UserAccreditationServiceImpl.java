package io.swagger.service;


import io.swagger.entity.ClientUser;
import io.swagger.entity.Document;
import io.swagger.entity.UserAccreditation;
import io.swagger.enums.Status;
import io.swagger.model.*;
import io.swagger.repository.DocumentRepository;
import io.swagger.repository.UserAccreditationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class UserAccreditationServiceImpl implements UserAccreditationService{

    @Autowired
    private UserAccreditationRepository userAccreditationRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ClientUserService clientUserService;

    @Override
    public AccreditationStatusResponse statusCreation(UserAccreditation userAccreditation) {
        UserAccreditation userAccreditationResponse = userAccreditationRepository.save(userAccreditation);
        return new AccreditationStatusResponse().accreditationId(String.valueOf(userAccreditationResponse.getAccreditation_id()));
    }

    @Override
    public UserAccreditation bodyToEntity (AccreditationStatusCreation body) {

        ClientUser user  = clientUserService.findById(body.getUserId()).get();

        Document document = new Document(body.getDocument().getName(), body.getDocument().getMimeType(), body.getDocument().getContent());

        documentRepository.save(document);

        return new UserAccreditation(user, body.getAccreditationType().toString(),document, Status.PENDING.name(), Timestamp.from(Instant.now()));

    }

    @Override
    public Optional<UserAccreditation> findById(Integer id) {
        return userAccreditationRepository.findById(id);
    }

    @Override
    public AccreditationStatusResponse updateStatus(Integer accreditationId, AccreditationStatusFinalization accreditationStatusFinalization) {
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

    private AccreditationStatusForUser accreditationsToResponse (ArrayList<UserAccreditation> list, String userId) {
        AccreditationStatus map = new AccreditationStatus();
        StatusDetails statusDetails;
        for (UserAccreditation userAccreditation: list){
            statusDetails = new StatusDetails(userAccreditation.getAccreditationType(), userAccreditation.getStatus());
            map.put(String.valueOf(userAccreditation.getAccreditation_id()), statusDetails);
        }
        return new AccreditationStatusForUser(userId, map);
    }
}
