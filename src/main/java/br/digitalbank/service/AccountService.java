package br.digitalbank.service;

import br.digitalbank.exceptions.AccountNotFoundException;
import br.digitalbank.model.Account;
import br.digitalbank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account findOrThrow(final String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(AccountNotFoundException::new);
    }

    public Account findByUserOrThrow(final String userId) {
        return accountRepository.findAccountByUser(userId)
                .orElseThrow(AccountNotFoundException::new);
    }

    public void balance(final String accountId) {
        final Account account = findOrThrow(accountId);

        System.out.println("\n\n\n\n================ SALDO BANCÁRIO ================");
        System.out.println("Você possui: R$ " + account.getBalance());
    }

}
