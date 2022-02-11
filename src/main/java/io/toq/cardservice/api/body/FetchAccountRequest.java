package io.toq.cardservice.api.body;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FetchAccountRequest {

    private String accountId;
}
