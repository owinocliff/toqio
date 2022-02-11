package io.toq.cardservice.api;

import io.swagger.annotations.ApiOperation;
import io.toq.cardservice.api.body.*;
import io.toq.cardservice.data.response.ResponseObject;
import io.toq.cardservice.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController {


    private final CreateAccountMongoByIdService createAccountMongoByIdService;
    private final GetAccountMongoByIdService getAccountMongoByIdService;
    private final UpdateAccountMongoByIdService updateAccountMongoByIdService;

    public AccountsController(CreateAccountMongoByIdService createAccountMongoByIdService,
                              GetAccountMongoByIdService getAccountMongoByIdService,
                              UpdateAccountMongoByIdService updateAccountMongoByIdService) {
        this.createAccountMongoByIdService = createAccountMongoByIdService;
        this.getAccountMongoByIdService = getAccountMongoByIdService;
        this.updateAccountMongoByIdService = updateAccountMongoByIdService;
    }


    @ApiOperation(value = "Create Account", notes = "Creates a user account")
    @PostMapping
    public ResponseEntity<ResponseObject> createAccount(@RequestBody CreateAccountRequest request) {
        return createAccountMongoByIdService.execute(request);
    }

    @ApiOperation(value = "Fetch Account", notes = "Fetches user account on id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getAccount(@RequestBody FetchAccountRequest request) {
        return getAccountMongoByIdService.execute(request);
    }

    @ApiOperation(value = "Update Account", notes = "Updating account details")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateAccount(@PathVariable("id") String id,
            @RequestBody UpdateAccountRequest request) {
        return updateAccountMongoByIdService.execute(request, id);
    }
}
