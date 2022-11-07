package io.swagger.service;

import io.swagger.exception.NotFoundException;
import io.swagger.entity.UserAccreditation;
import io.swagger.model.AccreditationStatusCreation;
import io.swagger.model.AccreditationStatusFinalization;
import io.swagger.model.AccreditationStatusForUser;
import io.swagger.model.AccreditationStatusResponse;

import java.util.Optional;


public interface UserAccreditationService {

    AccreditationStatusResponse statusCreation (UserAccreditation userAccreditation);

    UserAccreditation bodyToEntity (AccreditationStatusCreation body) throws NotFoundException;

    Optional<UserAccreditation> findById (Integer id);

    AccreditationStatusResponse updateStatus (Integer accreditationId, AccreditationStatusFinalization accreditationStatusFinalization);

    Iterable<UserAccreditation> findAllByUserId(String id);

    AccreditationStatusForUser getAllAccreditation(String userId);
}
