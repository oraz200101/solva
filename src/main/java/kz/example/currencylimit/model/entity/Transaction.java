package kz.example.currencylimit.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import kz.example.currencylimit.model.entity.base.BaseEntity;
import kz.example.currencylimit.model.entity.Limit;
import kz.example.currencylimit.model.enums.CurrencyShortName;
import kz.example.currencylimit.model.enums.ExpenseCategory;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import static kz.example.currencylimit.constants.swagger.TransactionSwaggerConstants.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction",schema = "currency_limit")
@SuperBuilder
public class Transaction extends BaseEntity {
    @Schema(description = FIELD_ACCOUNT_FROM_DESCRIPTION,example = FIELD_ACCOUNT_FROM_EXAMPLE)
    @Column(name = "account_from")
    private Long accountFrom;

    @Schema(description = FIELD_ACCOUNT_TO_DESCRIPTION,example = FIELD_ACCOUNT_TO_EXAMPLE)
    @Column(name = "account_to")
    private Long accountTo;

    @Schema(description = FIELD_CURRENCY_DESCRIPTION,example = FIELD_CURRENCY_EXAMPLE)
    @Column(name = "currency_short_name")
    @Enumerated(EnumType.STRING)
    private CurrencyShortName currencyShortName;

    @Schema(description = FIELD_SUM_DESCRIPTION,example = FIELD_SUM_EXAMPLE)
    @Column(name = "sum")
    private Double sum;

    @Schema(description = FIELD_DATE_DESCRIPTION,example = FIELD_DATE_EXAMPLE)
    @Column(name = "date_time_create")
    @CreationTimestamp
    private LocalDateTime dateTime;

    @Schema(description = FIELD_EXPENSE_CATEGORY_DESCRIPTION,example = FIELD_DATE_EXAMPLE)
    @Column(name = "expense_category")
    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;

    @Schema(description = FIELD_LIMIT_EXCEEDED_DESCRIPTION,example = FIELD_LIMIT_EXCEEDED_EXAMPLE)
    @Column(name = "limit_exceeded")
    private Boolean limitExceeded;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "limit_id")
    private Limit limit;

}
