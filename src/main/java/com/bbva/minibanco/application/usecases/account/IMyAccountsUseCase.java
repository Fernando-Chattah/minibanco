package com.bbva.minibanco.application.usecases.account;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.presentation.response.account.MyAccountsResponse;
import com.bbva.minibanco.utilities.exceptions.ClientNotFoundException;

import java.util.List;

public interface IMyAccountsUseCase {
    List<MyAccountsResponse> getMyAccounts(String personalId) throws ClientNotFoundException;
}
