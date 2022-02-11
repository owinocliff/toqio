package io.toq.cardservice.service;

import com.mongodb.client.result.UpdateResult;
import io.toq.cardservice.api.body.UpdateAccountRequest;
import io.toq.cardservice.data.constants.Constants;
import io.toq.cardservice.data.enums.ResponseCode;
import io.toq.cardservice.data.model.Account;
import io.toq.cardservice.data.response.ResponseObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UpdateAccountMongoByIdService {

    private final MongoTemplate mongoTemplate;

    public UpdateAccountMongoByIdService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ResponseEntity<ResponseObject> execute(UpdateAccountRequest request, String id) {

        var query = new Query();

        query.addCriteria(Criteria
                .where(Account.FIELD_ID)
                .is(id));

        var update = new Update();

        decideOnFieldsForUpdate(request, update);

        UpdateResult updateResult = mongoTemplate
                .updateFirst(query, update, Account.class);

        return ResponseEntity.ok()
                .body(
                        new ResponseObject().setStatus(Constants.FAIL_MESSAGE)
                                .setStatus(ResponseCode.FAILURE.getResponseCode())
                                .setData(updateResult.getModifiedCount()));
    }

    private Update decideOnFieldsForUpdate(UpdateAccountRequest request, Update update) {
        if (Objects.nonNull(request.getBicSwift())) {
            update.set("bicSwift", request.getBicSwift());
        }

        if (Objects.nonNull(request.getIban())) {
            update.set("iban", request.getIban());
        }
        return update;
    }
}
