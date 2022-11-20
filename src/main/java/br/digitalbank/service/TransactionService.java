package br.digitalbank.service;

import br.digitalbank.model.Account;
import br.digitalbank.model.Transaction;
import br.digitalbank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public void bankStatements(final Account account) {
        System.out.println("\n\n\n\n\n================= HISTÓRICO DE TRANSAÇÕES ===================");
        final List<Transaction> transactionList = transactionRepository
                .findBySenderIdOrRecipientIdOrderByCreatedAtDesc(account.getId(), account.getId());

        if (transactionList.isEmpty()) {
            System.out.println("Você não possui nenhuma transferência no momento.");
        }

        transactionList.stream()
                .map(t -> t.build(t, account))
                .toList();
    }

}
