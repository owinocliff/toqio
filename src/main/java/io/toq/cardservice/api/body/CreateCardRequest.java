package io.toq.cardservice.api.body;

import io.toq.cardservice.data.enums.CardType;
import lombok.Data;

@Data
public class CreateCardRequest {

    private String id;

    private CardType cardType;

    private String alias;

    private String accountId;
}
