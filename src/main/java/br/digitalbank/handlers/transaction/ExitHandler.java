package br.digitalbank.handlers.transaction;

import br.digitalbank.enums.TransactionType;
import br.digitalbank.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExitHandler implements TransactionHandler {

    @Override
    public void action(final Account account, final Double amount, final Double actualBalance) {
        System.exit(0);
    }

    @Override
    public TransactionType type() {
        return TransactionType.LOGOUT;
    }

}
