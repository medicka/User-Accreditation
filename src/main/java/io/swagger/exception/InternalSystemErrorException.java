package io.swagger.exception;

public class InternalSystemErrorException extends ApiException {
    private int code;

    public InternalSystemErrorException(int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}