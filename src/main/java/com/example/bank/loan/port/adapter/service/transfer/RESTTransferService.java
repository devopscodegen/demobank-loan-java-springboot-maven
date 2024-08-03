package com.example.bank.loan.port.adapter.service.transfer;

import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.example.bank.loan.domain.model.account.AccountId;
import com.example.bank.loan.domain.model.money.Money;
import com.example.bank.loan.domain.model.transfer.TransferId;
import com.example.bank.loan.domain.model.transfer.TransferService;

@Service
@Adapter
public class RESTTransferService implements TransferService {

    private String baseUrl;

    private RestClient restClient;

    private RestClient.Builder restClientBuilder;

    public RESTTransferService() {
        super();
        this.setBaseUrl("http://localhost:8077/api/v1/transfer");
        this.setRestClientBuilder(RestClient.builder());
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(this.getBaseUrl());
        this.setRestClient(this.getRestClientBuilder().uriBuilderFactory(factory).build());
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    private void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public RestClient getRestClient() {
        return restClient;
    }

    private void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public RestClient.Builder getRestClientBuilder() {
        return restClientBuilder;
    }

    private void setRestClientBuilder(RestClient.Builder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    public TransferId transferAmountBetweenAccounts(AccountId fromAccountId, AccountId toAccountId, Money amount) {
        TransferAmountBetweenAccountsResponse transferAmountBetweenAccountsResponse = this.getRestClient().post()
        .uri("/amount_between_accounts")
        .contentType(MediaType.APPLICATION_JSON)
        .body(new TransferAmountBetweenAccountsRequest(
            fromAccountId.getId(), 
            toAccountId.getId(),
            amount.getAmount(),
            amount.getCurrencyCode().toString())
        )
        .retrieve()
        .body(TransferAmountBetweenAccountsResponse.class);

        return new TransferId(transferAmountBetweenAccountsResponse.getTransferId());
    }
}
