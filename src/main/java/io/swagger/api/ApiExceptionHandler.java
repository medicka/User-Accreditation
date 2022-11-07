package io.swagger.api;


import io.swagger.exception.InternalSystemErrorException;
import io.swagger.exception.NotFoundException;
import io.swagger.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = UserAccreditationApi.class)
public class ApiExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
        log.error("Not Found Exception");
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = {ValidationException.class})
    public ResponseEntity<?> handleValidationException(ValidationException ex) {
        log.error("Validation failed");
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = {InternalSystemErrorException.class})
    public ResponseEntity<?> handleInternalSystemErrorException(InternalSystemErrorException ex) {
        log.error("Internal system error");
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
