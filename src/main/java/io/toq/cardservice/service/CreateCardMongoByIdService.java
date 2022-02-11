package io.toq.cardservice.service;

import io.toq.cardservice.api.body.CreateCardRequest;
import io.toq.cardservice.api.body.FetchAccountRequest;
import io.toq.cardservice.data.constants.Constants;
import io.toq.cardservice.data.enums.ResponseCode;
import io.toq.cardservice.data.model.Account;
import io.toq.cardservice.data.model.Card;
import io.toq.cardservice.data.response.ResponseObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCardMongoByIdService {

    private final MongoTemplate mongoTemplate;

    private final GetAccountMongoByIdService getAccountMongoByIdService;

    public CreateCardMongoByIdService(MongoTemplate mongoTemplate,
                                      GetAccountMongoByIdService getAccountMongoByIdService) {
        this.mongoTemplate = mongoTemplate;
        this.getAccountMongoByIdService = getAccountMongoByIdService;
    }

    public ResponseEntity<ResponseObject> execute(CreateCardRequest request) {

        ResponseEntity<ResponseObject> responseEntity =
                getAccountMongoByIdService.execute(new FetchAccountRequest(request.getAccountId()));

        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity;
        }

        Account account = new Account();
       account.getCards().add(
               new Card().setAccountId(request.getAccountId())
                       .setId(UUID.randomUUID().toString())
                       .setCardType(request.getCardType())
                       .setAlias(request.getAlias()));

        Account saved = mongoTemplate.save(account);

        return ResponseEntity.ok()
                .body(
                        new ResponseObject().setStatus(Constants.FAIL_MESSAGE)
                                .setStatus(ResponseCode.FAILURE.getResponseCode())
                                .setData(saved));
    }
}
