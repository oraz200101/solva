package kz.example.currencylimit.model.entity.base;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static kz.example.currencylimit.constants.swagger.BaseEntitySwaggerConstants.FIELD_ID_DESCRIPTION;
import static kz.example.currencylimit.constants.swagger.BaseEntitySwaggerConstants.FIELD_ID_EXAMPLE;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @Schema(description = FIELD_ID_DESCRIPTION,example = FIELD_ID_EXAMPLE)
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
