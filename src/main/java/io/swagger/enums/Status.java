package io.swagger.enums;

public enum Status {

    CONFIRMED("CONFIRMED"),

    EXPIRED("EXPIRED"),

    FAILED("FAILED"),

    PENDING("PENDING");

    private String value;

    Status(String value) {
        this.value = value;
    }

}
