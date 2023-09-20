package kz.example.currencylimit.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class CurrencyProperties {

    @Value("${twelve.api}")
    private String api;

    @Value("${twelve.symbol}")
    private String symbol;

    @Value("${twelve.interval}")
    private String interval;

    @Value("${twelve.timezone}")
    private String timezone;

    @Value("${twelve.date}")
    private String date;
}
