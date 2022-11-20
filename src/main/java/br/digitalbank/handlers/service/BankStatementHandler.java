package br.digitalbank.handlers.service;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;
import br.digitalbank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankStatementHandler implements ServiceHandler {

    private final TransactionService transactionService;

    @Override
    public Account action(final Account account) {
        transactionService.bankStatements(account);
        return account;
    }

    @Override
    public ServiceType type() {
        return ServiceType.BANK_STATEMENT;
    }
}
