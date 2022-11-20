package br.digitalbank.handlers.service;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;
import br.digitalbank.service.AccountService;
import br.digitalbank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BalanceHandler implements ServiceHandler {

    private final AccountService accountService;

    @Override
    public Account action(final Account account) {
        accountService.balance(account.getId());
        return account;
    }

    @Override
    public ServiceType type() {
        return ServiceType.BALANCE;
    }
}
