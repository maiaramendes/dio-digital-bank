package br.digitalbank.repository;

import br.digitalbank.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findBySenderIdOrRecipientIdOrderByCreatedAtDesc(@NonNull final String senderId,
                                                                              @NonNull final String recipientId);

}
