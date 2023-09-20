package kz.example.currencylimit.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kz.example.currencylimit.model.enums.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static kz.example.currencylimit.constants.swagger.LimitSwaggerConstants.*;
import static kz.example.currencylimit.constants.swagger.LimitSwaggerConstants.FIELD_LIMIT_EXPENSE_CATEGORY_EXAMPLE;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(title = LIMIT_RESPONSE_DTO)
public class LimitResponseDto {
    @Schema(description = FIELD_LIMIT_VALUE_DESCRIPTION, example = FIELD_LIMIT_VALUE_EXAMPLE)
    private Double limitValue;
    @Schema(description = FIELD_LIMIT_EXPENSE_CATEGORY_DESCRIPTION,example = FIELD_LIMIT_EXPENSE_CATEGORY_EXAMPLE)
    private ExpenseCategory expenseCategory;
    @Schema(description = FIELD_LIMIT_BALANCE_DESCRIPTION,example = FIELD_LIMIT_BALANCE_EXAMPLE)
    private Double limitBalance;
    private List<TransactionResponseDto> transactionResponseDtos;
}
