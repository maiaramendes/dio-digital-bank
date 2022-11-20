package br.digitalbank.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("accounts")
public class Account extends BaseDocument {

    @Size(min = 4, max = 4)
    private long number;

    private Double balance = 0.00;

    @DBRef(lazy = true)
    private User user;
}
