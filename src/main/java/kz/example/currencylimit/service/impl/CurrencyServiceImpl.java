package kz.example.currencylimit.service.impl;

import jakarta.transaction.Transactional;
import kz.example.currencylimit.client.CurrencyClient;
import kz.example.currencylimit.exception.NotFoundException;
import kz.example.currencylimit.model.entity.Currency;
import kz.example.currencylimit.utils.CurrencyProperties;
import kz.example.currencylimit.repository.CurrencyRepository;
import kz.example.currencylimit.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyClient client;
    private final CurrencyRepository repository;
    private final CurrencyProperties properties;

    @Override
    @Transactional
    public Currency saveOrPreviousClose() {
        Currency currency = client.getCurrency(properties.getSymbol(),
                properties.getInterval(),
                properties.getApi(),
                properties.getDate(), properties.getTimezone());
        currency.setDateCreate(LocalDate.now());

        if (currency.getStatus().equals("error")){
            return repository.findFirstByOrderByDateDesc().orElseThrow();
        }
        return repository.save(currency);
    }

    @Override
    public Currency getCurrencyForToday() {
        Optional<Currency> optionalCurrency=repository.findByDateCreate(LocalDate.now());
        if (optionalCurrency.isEmpty()){
         return saveOrPreviousClose();
        }
        else {
            return optionalCurrency.orElseThrow(()->new NotFoundException("валюта на сегодня не найдена"));
        }
    }
}
