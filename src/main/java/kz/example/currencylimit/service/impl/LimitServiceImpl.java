package kz.example.currencylimit.service.impl;

import jakarta.transaction.Transactional;
import kz.example.currencylimit.exception.NotFoundException;
import kz.example.currencylimit.mapper.LimitMapper;
import kz.example.currencylimit.model.entity.Transaction;
import kz.example.currencylimit.model.entity.Limit;
import kz.example.currencylimit.model.dto.LimitCreateDto;
import kz.example.currencylimit.model.dto.LimitResponseDto;
import kz.example.currencylimit.model.enums.CurrencyShortName;
import kz.example.currencylimit.model.enums.ExpenseCategory;
import kz.example.currencylimit.repository.LimitRepository;
import kz.example.currencylimit.service.LimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LimitServiceImpl implements LimitService {

    private final LimitRepository limitRepository;
    private final LimitMapper limitMapper;

    @Override
    public Limit createDefaultLimit(ExpenseCategory expenseCategory) {
        return Limit.builder()
                .limitValue(1000.0)
                .limitBalance(1000.0)
                .actual(true)
                .dateTimeCreate(LocalDateTime.now())
                .currencyShortName(CurrencyShortName.USD)
                .expenseCategory(expenseCategory)
                .build();
    }

    @Override
    @Transactional
    public LimitResponseDto createLimit(LimitCreateDto limitCreateDto) {
        Optional<Limit> optionalLimit = limitRepository
                .findByActualAndMonth(LocalDate.now().getMonthValue(), limitCreateDto.getExpenseCategory());
        if (optionalLimit.isEmpty()) {
            Limit newLimit = limitMapper.mapToLimitEntity(limitCreateDto);
            limitRepository.save(newLimit);
            return limitMapper.mapToLimitResponseDto(newLimit);
        } else {
            Limit limit = optionalLimit.orElseThrow(()->new NotFoundException(("лимит не найден")));
            limit.setActual(false);
            limitRepository.save(limit);
            Limit newLimit = createDefaultLimit(limitCreateDto.getExpenseCategory());
            newLimit.setLimitBalance(limitCreateDto.getLimitValue()-sumLimitTransactionSum(limit));
            newLimit.setLimitValue(limitCreateDto.getLimitValue());
            limitRepository.save(newLimit);
            return limitMapper.mapToLimitResponseDto(newLimit);
        }
    }

    @Override
    public List<LimitResponseDto> getAll() {
        List<Limit> limits = limitRepository.findAll();
        return limitMapper.mapToLimitResponseDtos(limits);
    }

    private Double sumLimitTransactionSum(Limit limit) {
        List<Transaction> transactions =  limit.getTransactions();
        return transactions.stream().mapToDouble(Transaction::getSum).sum();
    }
}
