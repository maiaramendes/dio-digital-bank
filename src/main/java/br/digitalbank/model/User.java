package br.digitalbank.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("users")
public class User extends BaseDocument {

    private String name;

    private String password;

    private String cpf;
}
