package br.digitalbank.handlers;

import br.digitalbank.enums.TransactionType;
import br.digitalbank.exceptions.AccountNotFoundException;
import br.digitalbank.model.Account;
import br.digitalbank.model.Transaction;
import br.digitalbank.repository.AccountRepository;
import br.digitalbank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WithdrawHandler implements ServiceHandler {

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    @Override
    public void action(final Account account, final Double amount, final Double actualBalance, final Long accountNumber) {
        final Optional<Account> recipient = accountRepository.findAccountByNumber(accountNumber);

        if (recipient.isEmpty()) {
            throw new AccountNotFoundException(accountNumber);
        }

        TransactionType.DEPOSIT.operation(recipient.get(), amount);
        accountRepository.save(recipient.get());

        type().operation(account, amount);
        accountRepository.save(account);

        final Transaction transaction = new Transaction()
                .builder()
                .lastBalance(actualBalance)
                .amount(amount)
                .type(type())
                .sender(account)
                .recipient(recipient.get())
                .build();

        transactionRepository.save(transaction);
    }

    @Override
    public TransactionType type() {
        return TransactionType.WITHDRAW;
    }
}
