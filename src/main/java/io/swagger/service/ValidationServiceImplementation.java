package io.swagger.service;

import io.swagger.exception.InternalSystemErrorException;
import io.swagger.exception.NotFoundException;
import io.swagger.exception.ValidationException;
import io.swagger.entity.ClientUser;
import io.swagger.entity.UserAccreditation;
import io.swagger.enums.Status;
import io.swagger.model.AccreditationStatusCreation;
import io.swagger.model.AccreditationStatusFinalization;
import io.swagger.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class ValidationServiceImplementation implements ValidationService{

    @Autowired
    private ClientUserService clientUserService;

    @Autowired
    private UserAccreditationService userAccreditationService;

    @Override
    public void validateAccreditationStatusCreationDetails(AccreditationStatusCreation accreditationStatusCreation) {
        validateUser(accreditationStatusCreation);
        validateDocument(accreditationStatusCreation.getDocument());
    }

    @Override
    public void validateAccreditationStatusFinalization(Integer accreditationId, AccreditationStatusFinalization accreditationStatusFinalization) {
        Optional<UserAccreditation> userAccreditation;

        try{
            userAccreditation = userAccreditationService.findById(accreditationId);
        }catch(Exception e) {
            String msg =  "No accreditation found for id: " + accreditationId;
            throw new InternalSystemErrorException(500,msg);
        }
        try {
            // If we get an exception, than Optional was empty
            userAccreditation.get();
        }catch (Exception e) {
            String msg =  "No accreditation found for id: " + accreditationId;
            throw new ValidationException(405,msg);
        }

        validateStatus(accreditationStatusFinalization, userAccreditation.get());

    }

    @Override
    public void validateAccreditationStatusForUser(String userID) {

        validateUserExistence(userID);
        validateUserHasAccreditations(userID);
    }

    private void validateUser(AccreditationStatusCreation accreditationStatusCreation){

        ClientUser clientUser = validateUserExistence(accreditationStatusCreation.getUserId());

        ArrayList<UserAccreditation> list;

        try{
            list = (ArrayList<UserAccreditation>) userAccreditationService.findAllByUserId(accreditationStatusCreation.getUserId());
        }catch (Exception e) {
            String msg =  "System Error while validating if user has accreditations " ;
            throw new InternalSystemErrorException(500,msg);
        }
        for (UserAccreditation accreditation: list){
            if(Status.PENDING.name().equals(accreditation.getStatus())){
                String msg =  "There is existing PENDING accreditation for this user: " + clientUser.getId();
                throw new ValidationException(405,msg);
            }
        }

    }

    private ClientUser validateUserExistence(String userId) {
        Optional<ClientUser> clientUser;
        try{
            clientUser = clientUserService.findById(userId);
        }catch(Exception e) {
            String msg =  "System Error while validating if user exists" + userId;
            throw new InternalSystemErrorException(500,msg);
        }
        try{
            // If we get an exception, than Optional was empty
            clientUser.get();
        }catch (Exception e) {
            String msg =  "No user found for id: " + userId;
            throw new NotFoundException(404,msg);
        }
        return clientUser.get();
    }

    private ArrayList<UserAccreditation> validateUserHasAccreditations(String userId) {

        ArrayList<UserAccreditation> accreditationList;
        try{
            accreditationList = (ArrayList<UserAccreditation>) userAccreditationService.findAllByUserId(userId);
        }catch (Exception e) {
            String msg =  "System Error while validating if user has accreditations " ;
            throw new InternalSystemErrorException(500,msg);
        }
        if(accreditationList == null || accreditationList.isEmpty()) {
            String msg =  "User " + userId + " has no accreditations" ;
            throw new NotFoundException(404,msg);
        }

        return accreditationList;

    }

    // we can improve these by setting a regex and checking if properties are empty strings or just white spaces
    private void validateDocument (Document document) {
        if (document.getName() == null || document.getName().equals("")) {
            String msg =  "Invalid input. Incorrect name ";
            throw new ValidationException(405, msg);
        }
        if (document.getMimeType() == null || document.getMimeType().equals("")) {
            String msg =  "Invalid input. Incorrect mime type. ";
            throw new ValidationException(405, msg);
        }
        if (document.getContent() == null || document.getContent().equals("")) {
            String msg =  "Invalid input. Incorrect content. ";
            throw new ValidationException(405, msg);
        }
    }

    private void validateStatus (AccreditationStatusFinalization accreditationStatusFinalization, UserAccreditation userAccreditation) {

        if(accreditationStatusFinalization.getOutcome() == null){
            String msg =  "Invalid input. Incorrect outcome value.";
            throw new ValidationException(405, msg);
        }

        if(Status.FAILED.name().equals(userAccreditation.getStatus())) {
            String msg =  "FAILED accreditations cant be updated ";
            throw new ValidationException(405, msg);
        }
        if(Status.CONFIRMED.name().equals(userAccreditation.getStatus()) &&
                !Status.EXPIRED.name().equals(accreditationStatusFinalization.getOutcome().name())) {
            String msg =  "CONFIRMED accreditations can only be EXPIRED";
            throw new ValidationException(405, msg);
        }
    }
}
