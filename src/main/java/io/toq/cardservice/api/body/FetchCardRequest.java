package io.toq.cardservice.api.body;

import lombok.Data;

@Data
public class FetchCardRequest {

    private String accountId;
    private String cardId;
}
