package io.toq.cardservice.service;

import io.toq.cardservice.api.body.FetchAccountRequest;
import io.toq.cardservice.data.constants.Constants;
import io.toq.cardservice.data.enums.ResponseCode;
import io.toq.cardservice.data.model.Account;
import io.toq.cardservice.data.response.ResponseObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetAccountMongoByIdService {

    private final MongoTemplate mongoTemplate;

    public GetAccountMongoByIdService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ResponseEntity<ResponseObject> execute(FetchAccountRequest request) {
        Account account = mongoTemplate
                .findById(request.getAccountId(), Account.class);

        if (account == null)
            return ResponseEntity.badRequest()
                    .body(
                            new ResponseObject().setStatus(Constants.FAIL_MESSAGE)
                                    .setStatus(ResponseCode.FAILURE.getResponseCode()));
        return ResponseEntity.ok()
                .body(
                        new ResponseObject().setStatus(Constants.FAIL_MESSAGE)
                                .setStatus(ResponseCode.FAILURE.getResponseCode())
                                .setData(account));
    }
}
