package io.toq.cardservice.data.enums;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum ResponseCode {


    SUCCESS("000"),
    FAILURE("001");

    private String responseCode;

    ResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    @JsonCreator
    public static ResponseCode valueOfType(String label) {

        for (ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.name().equalsIgnoreCase(label)) return responseCode;
        }
        return null;
    }
}
