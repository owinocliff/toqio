package io.toq.cardservice.service;

import io.toq.cardservice.api.body.CreateAccountRequest;
import io.toq.cardservice.data.constants.Constants;
import io.toq.cardservice.data.enums.ResponseCode;
import io.toq.cardservice.data.model.Account;
import io.toq.cardservice.data.response.ResponseObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateAccountMongoByIdService {

    private final MongoTemplate mongoTemplate;

    public CreateAccountMongoByIdService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ResponseEntity<ResponseObject> execute(CreateAccountRequest request) {
        Query query = new Query();
        query.addCriteria(Criteria
                .where(Account.FIELD_CLIENT_ID)
                .is(request.getClientId())
        );

        boolean exists = mongoTemplate.exists(query, Account.class);

        if (exists) {
            return ResponseEntity.badRequest()
                    .body(
                            new ResponseObject().setStatus(Constants.FAIL_MESSAGE)
                                    .setStatus(ResponseCode.FAILURE.getResponseCode()));
        }

        Account entity = new Account();
        entity.setId(UUID.randomUUID().toString());
        entity.setBicSwift(request.getBicSwift());
        entity.setClientId(request.getClientId());
        entity.setIban(request.getIban());
        Account saved = mongoTemplate.save(entity);

        return ResponseEntity.ok()
                .body(
                        new ResponseObject().setStatus(Constants.FAIL_MESSAGE)
                                .setStatus(ResponseCode.FAILURE.getResponseCode())
                                .setData(saved));
    }
}
