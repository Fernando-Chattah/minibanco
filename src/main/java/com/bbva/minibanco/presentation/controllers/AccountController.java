package com.bbva.minibanco.presentation.controllers;

import com.bbva.minibanco.application.usecases.account.IAccountFindByUseCase;
import com.bbva.minibanco.application.usecases.account.IAccountListUseCase;
import com.bbva.minibanco.application.usecases.account.IMyAccountsUseCase;
import com.bbva.minibanco.application.usecases.client.IAccountEnableDisableUseCase;
import com.bbva.minibanco.application.usecases.client.IClientFindByUseCase;
import com.bbva.minibanco.application.usecases.account.IAccountCreateUseCase;
import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.presentation.mapper.AccountPresentationMapper;
import com.bbva.minibanco.presentation.request.EnableDisableRequest;
import com.bbva.minibanco.presentation.request.account.AccountCreateRequest;
import com.bbva.minibanco.presentation.request.account.AccountFindRequest;
import com.bbva.minibanco.presentation.response.account.AccountResponse;
import com.bbva.minibanco.presentation.response.account.MyAccountsResponse;
import com.bbva.minibanco.presentation.response.client.ClientCreateResponse;
import com.bbva.minibanco.presentation.response.client.ClientFindResponse;
import com.bbva.minibanco.presentation.response.errors.ErrorResponse;
import com.bbva.minibanco.utilities.ControllerUtils;
import com.bbva.minibanco.utilities.ErrorCodes;
import com.bbva.minibanco.utilities.ErrorDescriptions;
import com.bbva.minibanco.utilities.exceptions.ErrorWhenSavingException;
import com.bbva.minibanco.utilities.exceptions.RecordNotFoundException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final IAccountCreateUseCase accountCreateUseCase;
    private final IAccountFindByUseCase accountFindByUseCase;
    private final IAccountListUseCase accountListUseCase;
    private final IMyAccountsUseCase myAccountsUseCase;
    private final IAccountEnableDisableUseCase enableDisableUseCase;
    private final AccountPresentationMapper accountPresentationMapper;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> create(@Valid @RequestBody AccountCreateRequest request, BindingResult bindingResult) {
        ResponseEntity<ErrorResponse> errorResponse = getErrorResponseResponseEntity(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Account savedAccount = accountCreateUseCase.create(request.getClientId(), request.getCurrency());
            return ResponseEntity.status(HttpStatus.CREATED).body(accountPresentationMapper.domainToResponse(savedAccount));
        } catch (RecordNotFoundException e) {
            ArrayList<String> errors = new ArrayList<>();
            errors.add(ErrorDescriptions.CLIENT_NOT_FOUND);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage(), errors));
        } catch (Exception e) {
            ArrayList<String> errors = new ArrayList<>();
            errors.add(ErrorDescriptions.ERROR_WHEN_SAVING_ACCOUNT);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage(), errors));
        }

    }

    @GetMapping(value = "/find", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> find(@Valid @RequestBody AccountFindRequest request, BindingResult bindingResult) {
        ResponseEntity<ErrorResponse> errorResponse = getErrorResponseResponseEntity(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Optional<Account> account = null;

            if(request.getAccountId() != 0 )
                account = accountFindByUseCase.findById(request.getAccountId());

            if(!account.isPresent()){
                ArrayList<String> errors = new ArrayList<>();
                errors.add(ErrorDescriptions.ACCOUNT_NOT_FOUND);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ErrorCodes.RECORD_NOT_FOUND, errors));
            }

            return ResponseEntity.status(HttpStatus.FOUND).body(accountPresentationMapper.findOneToResponse(account.get()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage(), null));
        }

    }

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<?> list() {

        try {
            List<Account> accountList = null;
            List<AccountResponse> accountResponse = new ArrayList<>();

            accountList = accountListUseCase.getAccountList();

            if(accountList == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("No se pudo obtener la lista de cuentas", null));

            for (Account account :
                    accountList) {
                accountResponse.add(accountPresentationMapper.domainToResponse(account));
            }

            return ResponseEntity.status(HttpStatus.FOUND).body(accountResponse);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage(), null));
        }
    }

    @GetMapping(value = "/myaccounts", produces = "application/json")
    public ResponseEntity<?> myAccounts() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            List<MyAccountsResponse> myAccountsResponseList = myAccountsUseCase.getMyAccounts(username);

            return ResponseEntity.status(HttpStatus.FOUND).body(myAccountsResponseList);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage(), null));
        }
    }

    @PatchMapping(value = "/enable", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> enable(@Valid @RequestBody EnableDisableRequest request, BindingResult bindingResult) {
        ResponseEntity<ErrorResponse> errorResponse = getErrorResponseResponseEntity(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            request.setActive(true);
            AccountResponse updatedClient = enableDisableUseCase.switchActive(request);

            return ResponseEntity.status(HttpStatus.CREATED).body(updatedClient);

        } catch (ErrorWhenSavingException e) {
            return ControllerUtils.getBadRequest(e, ErrorDescriptions.ERROR_WHEN_SAVING_CLIENT);
        } catch (RecordNotFoundException e) {
            return ControllerUtils.getBadRequest(e, ErrorDescriptions.CLIENT_NOT_FOUND);
        } catch (Exception e ){
            return ControllerUtils.getBadRequest(e, "");
        }
    }

    @PatchMapping(value = "/disable", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> disable(@Valid @RequestBody EnableDisableRequest request, BindingResult bindingResult) {
        ResponseEntity<ErrorResponse> errorResponse = getErrorResponseResponseEntity(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            request.setActive(false);
            AccountResponse updatedClient = enableDisableUseCase.switchActive(request);

            return ResponseEntity.status(HttpStatus.CREATED).body(updatedClient);

        } catch (ErrorWhenSavingException e) {
            return ControllerUtils.getBadRequest(e, ErrorDescriptions.ERROR_WHEN_SAVING_CLIENT);
        } catch (RecordNotFoundException e) {
            return ControllerUtils.getBadRequest(e, ErrorDescriptions.CLIENT_NOT_FOUND);
        } catch (Exception e ){
            return ControllerUtils.getBadRequest(e, "");
        }
    }

    //TODO: list accounts

    //TODO: delete accounts

    private static ResponseEntity<ErrorResponse> getErrorResponseResponseEntity(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());

            ErrorResponse errorResponse = new ErrorResponse("Error de validación", errors);
            return ResponseEntity.badRequest().body(errorResponse);
        }
        return null;
    }

}
