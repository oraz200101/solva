package kz.example.currencylimit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyLimitApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyLimitApplication.class, args);
    }

}
