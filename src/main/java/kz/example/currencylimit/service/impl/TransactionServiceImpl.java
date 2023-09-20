package kz.example.currencylimit.service.impl;

import jakarta.transaction.Transactional;
import kz.example.currencylimit.exception.NotFoundException;
import kz.example.currencylimit.mapper.TransactionMapper;
import kz.example.currencylimit.model.entity.Currency;
import kz.example.currencylimit.model.entity.Limit;
import kz.example.currencylimit.model.entity.Transaction;
import kz.example.currencylimit.model.dto.TransactionCreateDto;
import kz.example.currencylimit.model.dto.TransactionResponseDto;
import kz.example.currencylimit.model.enums.CurrencyShortName;
import kz.example.currencylimit.repository.LimitRepository;
import kz.example.currencylimit.repository.TransactionRepository;
import kz.example.currencylimit.service.CurrencyService;
import kz.example.currencylimit.service.LimitService;
import kz.example.currencylimit.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final LimitRepository limitRepository;
    private final TransactionRepository transactionRepository;
    private final LimitService limitService;
    private final TransactionMapper mapper;
    private final CurrencyService currencyService;

    @Override
    @Transactional
    public TransactionResponseDto createTransaction(TransactionCreateDto transactionCreateDto) {
        Transaction transaction = mapper.mapToTransactionEntity(transactionCreateDto);
        changeActual();
        Optional<Limit> optionalLimit = limitRepository
                .findByActualAndMonth(LocalDate.now().getMonthValue(), transactionCreateDto.getExpenseCategory());
        if (optionalLimit.isEmpty()) {
            Limit newLimit = limitService.createDefaultLimit(transactionCreateDto.getExpenseCategory());
            checkToExceeded(newLimit, transaction);
            limitRepository.save(newLimit);
            transaction.setLimit(newLimit);
            transactionRepository.save(transaction);
            return mapper.mapToResponseDto(transaction);
        } else {
            Limit currentLimit = optionalLimit.orElseThrow();
            checkToExceeded(currentLimit, transaction);
            transaction.setLimit(currentLimit);
            transactionRepository.save(transaction);
            return mapper.mapToResponseDto(transaction);
        }
    }

    public void checkToExceeded(Limit limit, Transaction transaction) {
        Currency currency = currencyService.getCurrencyForToday();
        transaction.setCurrencyShortName(CurrencyShortName.RUB);
        limit.setLimitBalance(limit.getLimitBalance() - transaction.getSum() / currency.getValues().get(0).getClose());
        transaction.setLimitExceeded(limit.getLimitBalance() < transaction.getSum());
    }

    private void changeActual() {
        Optional<Limit> optionalLimit = limitRepository.findByActualTrueExpiredMonth(LocalDate.now().getMonthValue());
        if (optionalLimit.isPresent()) {
            Limit limit = optionalLimit.orElseThrow(()->new NotFoundException("лимит не найден"));
            limit.setActual(false);
            limitRepository.save(limit);
        }
    }

    @Override
    @Transactional
    public Page<TransactionResponseDto> getAllTransactions(Pageable pageable, Boolean limitExceeded) {
        List<Transaction> transactions = transactionRepository.findAllTransactions(limitExceeded);
        List<TransactionResponseDto> transactionResponseDtos = mapper.mapToResponseDtos(transactions);
        int start = (int) pageable.getOffset();
        int end = (Math.min((start + pageable.getPageSize()), transactionResponseDtos.size()));
        return new PageImpl<>(transactionResponseDtos.subList(start,end), pageable, transactionResponseDtos.size());
    }
}
