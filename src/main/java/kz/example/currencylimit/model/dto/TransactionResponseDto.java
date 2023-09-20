package kz.example.currencylimit.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kz.example.currencylimit.model.enums.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static kz.example.currencylimit.constants.swagger.TransactionSwaggerConstants.*;
import static kz.example.currencylimit.constants.swagger.TransactionSwaggerConstants.FIELD_ACCOUNT_TO_EXAMPLE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = TRANSACTION_RESPONSE_DTO)
public class TransactionResponseDto {

    @Schema(description = FIELD_ACCOUNT_FROM_DESCRIPTION,example = FIELD_ACCOUNT_FROM_EXAMPLE)
    private Long accountFrom;

    @Schema(description = FIELD_ACCOUNT_TO_DESCRIPTION,example = FIELD_ACCOUNT_TO_EXAMPLE)
    private Long accountTo;

    @Schema(description = FIELD_SUM_DESCRIPTION,example = FIELD_SUM_EXAMPLE)
    private Double sum;

    @Schema(description = FIELD_DATE_DESCRIPTION,example = FIELD_DATE_EXAMPLE)
    private LocalDateTime dateTime;
    @Schema(description = FIELD_LIMIT_EXCEEDED_DESCRIPTION, example = FIELD_LIMIT_EXCEEDED_EXAMPLE)
    private Boolean limitExceeded;

    @Schema(description = FIELD_EXPENSE_CATEGORY_DESCRIPTION,example = FIELD_EXPENSE_CATEGORY_EXAMPLE)
    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;
}
