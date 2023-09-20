package kz.example.currencylimit.client;

import kz.example.currencylimit.model.entity.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(value = "currency-client", url = "https://api.twelvedata.com/time_series")
public interface CurrencyClient {
    @GetMapping
    Currency getCurrency(@RequestParam(name = "symbol") String symbol,
                         @RequestParam(name = "interval") String interval,
                         @RequestParam(name = "apikey") String apiKey,
                         @RequestParam(name = "date") String date,
                         @RequestParam(name = "timezone") String timeZone);
}
