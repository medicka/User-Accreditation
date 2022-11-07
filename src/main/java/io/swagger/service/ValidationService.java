package io.swagger.service;

import io.swagger.model.AccreditationStatusCreation;
import io.swagger.model.AccreditationStatusFinalization;

public interface ValidationService {

    void validateAccreditationStatusCreationDetails(AccreditationStatusCreation accreditationStatusCreation);

    void validateAccreditationStatusFinalization(Integer accreditationId, AccreditationStatusFinalization accreditationStatusFinalization);

    void validateAccreditationStatusForUser(String userID);
}
