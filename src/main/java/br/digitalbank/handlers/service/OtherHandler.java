package br.digitalbank.handlers.service;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.enums.TransactionType;
import br.digitalbank.handlers.transaction.TransactionHandler;
import br.digitalbank.handlers.transaction.TransferHandler;
import br.digitalbank.model.Account;
import br.digitalbank.model.User;
import br.digitalbank.service.AccountService;
import br.digitalbank.service.TransactionService;
import br.digitalbank.service.UserService;
import br.digitalbank.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class OtherHandler implements ServiceHandler {

    private final List<TransactionHandler> transactionHandlerList;

    @Override
    public Account action(Account account) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("============= MENU DE TRANSAÇÕES =============");
        TransactionType.getMenu();

        final TransactionType type = TransactionType.toTransactionType(scanner.nextInt());

        System.out.println("Digite a quantia:");
        final Double amount = scanner.nextDouble();

        transactionHandlerList.stream()
                .filter(t -> t.type().equals(type))
                .findFirst()
                .ifPresent(transactionHandler ->
                        transactionHandler.action(account, amount, account.getBalance()));

        return account;
    }

    @Override
    public ServiceType type() {
        return ServiceType.OTHERS;
    }
}
