package br.digitalbank.handlers.transaction;

import br.digitalbank.enums.TransactionType;
import br.digitalbank.model.Account;
import br.digitalbank.model.Transaction;
import br.digitalbank.repository.AccountRepository;
import br.digitalbank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepositHandler implements TransactionHandler {

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    @Override
    public void action(final Account account, final Double amount, final Double actualBalance) {
        type().operation(account, amount);
        accountRepository.save(account);

        final Transaction transaction = new Transaction()
                .builder()
                .lastBalance(actualBalance)
                .amount(amount)
                .recipient(account)
                .sender(account)
                .type(type())
                .build();

        transactionRepository.save(transaction);
    }

    @Override
    public TransactionType type() {
        return TransactionType.DEPOSIT;
    }

}
