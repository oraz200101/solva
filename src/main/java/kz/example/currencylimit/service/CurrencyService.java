package kz.example.currencylimit.service;

import kz.example.currencylimit.model.entity.Currency;


public interface CurrencyService {
    Currency saveOrPreviousClose();
    Currency getCurrencyForToday();
}
