package kz.example.currencylimit.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kz.example.currencylimit.model.enums.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static kz.example.currencylimit.constants.swagger.LimitSwaggerConstants.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = LIMIT_CREATE_DTO_TITLE)
public class LimitCreateDto {
    @Schema(description = FIELD_LIMIT_VALUE_DESCRIPTION, example = FIELD_LIMIT_VALUE_EXAMPLE)
    private Double limitValue;
    @Schema(description = FIELD_LIMIT_EXPENSE_CATEGORY_DESCRIPTION,example = FIELD_LIMIT_EXPENSE_CATEGORY_EXAMPLE)
    private ExpenseCategory expenseCategory;
}
