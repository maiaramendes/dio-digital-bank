package br.digitalbank.handlers.transaction;

import br.digitalbank.enums.TransactionType;
import br.digitalbank.model.Account;

public interface TransactionHandler {

    void action(final Account account, final Double amount, final Double actualBalance);

    TransactionType type();

}
