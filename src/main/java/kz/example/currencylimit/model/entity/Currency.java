package kz.example.currencylimit.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("currency")
@Builder
public class Currency {

    @Id
    @GeneratedValue
    private String id;

    private Meta meta;

    private String status;


    private LocalDate dateCreate;

    private List<Value> values;
}
