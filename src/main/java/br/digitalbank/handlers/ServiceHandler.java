package br.digitalbank.handlers;

import br.digitalbank.enums.TransactionType;
import br.digitalbank.model.Account;

public interface ServiceHandler {

    void action(final Account account, final Double amount, final Double actualBalance, final Long accountNumber);

    TransactionType type();
}
