package br.digitalbank.handlers.transaction;

import br.digitalbank.enums.TransactionType;
import br.digitalbank.exceptions.AccountNotFoundException;
import br.digitalbank.model.Account;
import br.digitalbank.model.Transaction;
import br.digitalbank.model.User;
import br.digitalbank.repository.AccountRepository;
import br.digitalbank.repository.TransactionRepository;
import br.digitalbank.service.AccountService;
import br.digitalbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class TransferHandler implements TransactionHandler {

    private final AccountService accountService;

    private final TransactionRepository transactionRepository;

    private final UserService userService;

    private final AccountRepository accountRepository;

    @Override
    public void action(final Account account, final Double amount, final Double actualBalance) {
        final Scanner scanner = new Scanner(System.in);

        if (amount > actualBalance) {
            System.out.print("Saldo insuficiente.");
            return;
        }

        System.out.println("Digite o cpf do destinatário:");
        final String cpf = scanner.next();

        final User user = userService.findUserByCpfOrThrow(cpf);
        final Account recipient = accountService.findByUserOrThrow(user.getId());

        TransactionType.DEPOSIT.operation(recipient, amount);
        accountRepository.save(recipient);

        type().operation(account, amount);
        accountRepository.save(account);

        final Transaction transaction = new Transaction()
                .builder()
                .lastBalance(actualBalance)
                .amount(amount)
                .type(type())
                .sender(account)
                .recipient(recipient)
                .build();

        transactionRepository.save(transaction);
    }

    @Override
    public TransactionType type() {
        return TransactionType.TRANSFER;
    }
}
