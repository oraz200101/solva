package kz.example.currencylimit.service;

import kz.example.currencylimit.model.entity.Limit;
import kz.example.currencylimit.model.dto.LimitCreateDto;
import kz.example.currencylimit.model.dto.LimitResponseDto;
import kz.example.currencylimit.model.enums.ExpenseCategory;

import java.util.List;

public interface LimitService {
    Limit createDefaultLimit(ExpenseCategory expenseCategory);

    LimitResponseDto createLimit(LimitCreateDto limitCreateDto);

    List<LimitResponseDto> getAll();
}
