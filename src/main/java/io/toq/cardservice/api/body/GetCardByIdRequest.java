package io.toq.cardservice.api.body;

import lombok.Data;
import java.io.Serializable;

@Data
public class GetCardByIdRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
}
