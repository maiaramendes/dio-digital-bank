package br.digitalbank.model;

import br.digitalbank.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseDocument {

    @Id
    private String id;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    public String createdAtFormatted() {
        return Utils.formatDate(createdAt);
    }

}
