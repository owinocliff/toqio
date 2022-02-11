package io.toq.cardservice.api.body;

import lombok.Data;

@Data
public class UpdateAccountRequest {

    private String iban;

    private String bicSwift;
}
