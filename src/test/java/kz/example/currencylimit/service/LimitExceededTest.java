package kz.example.currencylimit.service;

import kz.example.currencylimit.mapper.TransactionMapper;
import kz.example.currencylimit.model.entity.Currency;
import kz.example.currencylimit.model.entity.Limit;
import kz.example.currencylimit.model.entity.Transaction;
import kz.example.currencylimit.model.entity.Value;
import kz.example.currencylimit.model.enums.CurrencyShortName;
import kz.example.currencylimit.repository.LimitRepository;
import kz.example.currencylimit.repository.TransactionRepository;
import kz.example.currencylimit.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class LimitExceededTest {

    private TransactionService transactionService;
    private LimitRepository limitRepository;
    private TransactionRepository transactionRepository;
    private LimitService limitService;
    private TransactionMapper mapper;
    private CurrencyService currencyService;

    @BeforeEach
    void setUp() {
        System.out.println("Before each test");
        limitRepository = Mockito.mock(LimitRepository.class);
        currencyService = Mockito.mock(CurrencyService.class);
        mapper = Mockito.mock(TransactionMapper.class);
        limitService = Mockito.mock(LimitService.class);
        transactionRepository = Mockito.mock(TransactionRepository.class);
        transactionService = new TransactionServiceImpl(limitRepository, transactionRepository, limitService, mapper, currencyService);
    }

    @Test
    void checkToExceeded() {
        Value value = Value.builder()
                .close(100.0)
                .build();
        List<Value> values = new ArrayList<>();
        values.add(value);
        Currency currency = Currency.builder().id("1w2e3e").values(values).build();
        Limit limit = Limit.builder().id(1L).limitBalance(1000.0).currencyShortName(CurrencyShortName.USD).build();
        Transaction lessThanLimitTransaction = Transaction.builder().id(1L).sum(500.0).currencyShortName(CurrencyShortName.RUB)
                .build();
        Transaction moreThanLimitTransaction = Transaction.builder().id(2L).sum(10000000.0).currencyShortName(CurrencyShortName.RUB)
                .build();
        Mockito.when(currencyService.getCurrencyForToday()).thenReturn(currency);
        transactionService.checkToExceeded(limit, lessThanLimitTransaction);
        transactionService.checkToExceeded(limit,moreThanLimitTransaction);
        Assertions.assertFalse(lessThanLimitTransaction.getLimitExceeded());
        Assertions.assertTrue(moreThanLimitTransaction.getLimitExceeded());
    }
}
