package kz.example.currencylimit.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import kz.example.currencylimit.model.entity.base.BaseEntity;
import kz.example.currencylimit.model.enums.CurrencyShortName;
import kz.example.currencylimit.model.enums.ExpenseCategory;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

import static kz.example.currencylimit.constants.swagger.LimitSwaggerConstants.*;
import static kz.example.currencylimit.constants.swagger.LimitSwaggerConstants.FIELD_LIMIT_BALANCE_EXAMPLE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "limit", schema = "currency_limit")
@SuperBuilder
public class Limit extends BaseEntity {

    @Schema(description = FIELD_LIMIT_VALUE_DESCRIPTION, example = FIELD_LIMIT_VALUE_EXAMPLE)
    @Column(name = "limit_value")
    private Double limitValue;

    @Schema(description = FIELD_LIMIT_BALANCE_DESCRIPTION,example = FIELD_LIMIT_BALANCE_EXAMPLE)
    @Column(name = "limit_balance")
    private Double limitBalance;

    @Schema(description = FIELD_LIMIT_EXPENSE_CATEGORY_DESCRIPTION,example = FIELD_LIMIT_EXPENSE_CATEGORY_EXAMPLE)
    @Column(name = "expense_category")
    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;

    @Schema(description = FIELD_LIMIT_DATE_DESCRIPTION,example = FIELD_LIMIT_DATE_EXAMPLE)
    @Column(name = "date_time_create")
    private LocalDateTime dateTimeCreate;

    @Schema(description = FIELD_LIMIT_ACTUAL_DESCRIPTION,example = FIELD_LIMIT_ACTUAL_EXAMPLE)
    @Column(name = "actual")
    private Boolean actual;

    @Schema(description = FIELD_LIMIT_CURRENCY_DESCRIPTION,example = FIELD_LIMIT_CURRENCY_EXAMPLE)
    @Column(name = "currency_short_name")
    @Enumerated(EnumType.STRING)
    private CurrencyShortName currencyShortName;

    @OneToMany(mappedBy = "limit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

}
