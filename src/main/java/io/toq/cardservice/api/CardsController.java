package io.toq.cardservice.api;

import io.swagger.annotations.ApiOperation;
import io.toq.cardservice.api.body.CreateCardRequest;
import io.toq.cardservice.api.body.FetchCardRequest;
import io.toq.cardservice.api.body.FetchCardsRequest;
import io.toq.cardservice.api.body.UpdateCardRequest;
import io.toq.cardservice.data.response.ResponseObject;
import io.toq.cardservice.service.CreateCardMongoByIdService;
import io.toq.cardservice.service.GetAllCardsMongoByIdService;
import io.toq.cardservice.service.GetCardMongoByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/card")
public class CardsController {

    private final CreateCardMongoByIdService createCardMongoByIdService;
    private final GetCardMongoByIdService getCardMongoByIdService;
    private final GetAllCardsMongoByIdService getAllCardsMongoByIdService;


    public CardsController(CreateCardMongoByIdService createCardMongoByIdService,
                           GetCardMongoByIdService getCardMongoByIdService,
                           GetAllCardsMongoByIdService getAllCardsMongoByIdService) {
        this.createCardMongoByIdService = createCardMongoByIdService;
        this.getCardMongoByIdService = getCardMongoByIdService;
        this.getAllCardsMongoByIdService = getAllCardsMongoByIdService;
    }


    @ApiOperation(value = "Create Card", notes = "Creates a card entry against a user account")
    @PostMapping
    public ResponseEntity<ResponseObject> createCard(@RequestBody CreateCardRequest request) {
        return createCardMongoByIdService.execute(request);
    }

    @ApiOperation(value = "Fetch Card", notes = "Fetches user card on id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getCard(@RequestBody FetchCardRequest request) {
        return getCardMongoByIdService.execute(request);
    }

    @ApiOperation(value = "Fetch Cards", notes = "Fetches all user cards")
    @GetMapping("/all/{id}")
    public ResponseEntity<ResponseObject> getAllCards(@RequestBody FetchCardsRequest request) {
        return getAllCardsMongoByIdService.execute(request);
    }
}
