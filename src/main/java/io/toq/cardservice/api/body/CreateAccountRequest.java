package io.toq.cardservice.api.body;

import lombok.Data;

@Data
public class CreateAccountRequest {

    private String iban;

    private String bicSwift;

    private String clientId;
}
