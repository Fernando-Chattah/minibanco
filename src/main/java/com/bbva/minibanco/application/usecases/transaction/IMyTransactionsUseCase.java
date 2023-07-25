package com.bbva.minibanco.application.usecases.transaction;

import com.bbva.minibanco.presentation.response.account.MyAccountsResponse;
import com.bbva.minibanco.utilities.exceptions.ClientNotFoundException;

import java.util.List;

public interface IMyTransactionsUseCase {
    List<MyAccountsResponse> getMyAccounts(String personalId) throws ClientNotFoundException;
}
