package br.digitalbank.service;

import br.digitalbank.exceptions.AccountNotFoundException;
import br.digitalbank.exceptions.PasswordIncorrectException;
import br.digitalbank.exceptions.UserAlreadyExistsException;
import br.digitalbank.model.Account;
import br.digitalbank.model.User;
import br.digitalbank.repository.AccountRepository;
import br.digitalbank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AccountRepository accountRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public Account create(final String name, final String cpf, final String password) {
        final boolean userAlreadyExists = userRepository.findUserByCpfOrName(cpf, name);

        if (userAlreadyExists) {
            throw new UserAlreadyExistsException();
        }

        final User user = new User()
                .builder()
                .cpf(cpf)
                .name(name)
                .password(passwordEncoder.encode(password))
                .build();

        userRepository.save(user);
        System.out.print(user.getId());

        final Account account = new Account()
                .builder()
                .number(new Random().nextLong())
                .balance(0.00)
                .user(user)
                .build();

        accountRepository.save(account);
        System.out.print(account.getId());
        return account;
    }

    public Account login(final String cpf, final String password) {
        final Optional<User> user = userRepository.findByCpf(cpf);

        if (user.isEmpty()) {
            throw new AccountNotFoundException();
        }

        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            throw new PasswordIncorrectException();
        }

        final Optional<Account> account = accountRepository.findAccountByUser(user.get().getId());

        if (account.isEmpty()) {
            throw new AccountNotFoundException();
        }

        return account.get();
     }
}
