package br.digitalbank.handlers;

import br.digitalbank.enums.TransactionType;
import br.digitalbank.model.Account;
import br.digitalbank.model.Transaction;
import br.digitalbank.repository.AccountRepository;
import br.digitalbank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositHandler implements ServiceHandler {

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    @Override
    public void action(final Account account, final Double amount, final Double actualBalance, final Long accountNumber) {
        type().operation(account, amount);
        accountRepository.save(account);

        final Transaction transaction = new Transaction()
                .builder()
                .lastBalance(actualBalance)
                .amount(amount)
                .type(type())
                .build();

        transactionRepository.save(transaction);
    }

    @Override
    public TransactionType type() {
        return TransactionType.DEPOSIT;
    }
}
