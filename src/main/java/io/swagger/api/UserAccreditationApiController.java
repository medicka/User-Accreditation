package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.model.AccreditationStatusCreation;
import io.swagger.model.AccreditationStatusFinalization;
import io.swagger.model.AccreditationStatusForUser;
import io.swagger.model.AccreditationStatusResponse;
import io.swagger.service.UserAccreditationService;
import io.swagger.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T09:31:38.352Z")

@RestController
public class UserAccreditationApiController implements UserAccreditationApi {

    private static final Logger log = LoggerFactory.getLogger(UserAccreditationApiController.class);

    @Autowired
    private UserAccreditationService userAccreditationService;

    @Autowired
    private ValidationService validationService;


    public ResponseEntity<AccreditationStatusResponse> createAccreditationStatus(@ApiParam(value = "accreditation status that we want to create", required = true) @Valid @RequestBody AccreditationStatusCreation body) {


        validationService.validateAccreditationStatusCreationDetails(body);
        log.info("Validation sucessfull!");
        return new ResponseEntity<AccreditationStatusResponse>(userAccreditationService.statusCreation(userAccreditationService.bodyToEntity(body)), HttpStatus.OK);
    }

    public ResponseEntity<AccreditationStatusResponse> finalizeAccreditationStatus(@ApiParam(value = "Id of the accreditation", required = true) @PathVariable("accreditationId") Integer accreditationId, @ApiParam(value = "accreditation status that we want to finalize (outcome)", required = true) @Valid @RequestBody AccreditationStatusFinalization body) {

        validationService.validateAccreditationStatusFinalization(accreditationId, body);
        log.info("Validation sucessfull!");
        return new ResponseEntity<AccreditationStatusResponse>(userAccreditationService.updateStatus(accreditationId, body), HttpStatus.OK);
    }

    public ResponseEntity<AccreditationStatusForUser> getAccreditationStatus(@ApiParam(value = "Id of the user", required = true) @PathVariable("userId") String userId) {

        validationService.validateAccreditationStatusForUser(userId);
        log.info("Validation sucessfull!");
        return new ResponseEntity<AccreditationStatusForUser>(userAccreditationService.getAllAccreditation(userId), HttpStatus.OK);
    }

}
