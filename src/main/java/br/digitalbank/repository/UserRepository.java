package br.digitalbank.repository;

import br.digitalbank.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query(exists = true)
    boolean findUserByCpfOrName(final String cpf, final String name);

    Optional<User> findByCpf(final String cpf);
}
