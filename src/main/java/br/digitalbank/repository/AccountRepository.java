package br.digitalbank.repository;

import br.digitalbank.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findAccountByNumber(final long number);

    Optional<Account> findAccountByUser(final String user);

}
