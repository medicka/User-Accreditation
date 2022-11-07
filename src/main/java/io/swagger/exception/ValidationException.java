package io.swagger.exception;


public class ValidationException extends ApiException {
    // private int code;
    public ValidationException(int code, String msg) {
        super(code, msg);
        //this.code = code;
    }
}