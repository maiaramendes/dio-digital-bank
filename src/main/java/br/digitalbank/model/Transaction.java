package br.digitalbank.model;

import br.digitalbank.enums.TransactionType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("transactions")
public class Transaction extends BaseDocument {

    private TransactionType type;

    private Double lastBalance = 0.00;

    private Double actualBalance = 0.00;

    private Double amount;

    @DBRef(lazy = true)
    private Account sender;

    @DBRef(lazy = true)
    private Account recipient;
}
