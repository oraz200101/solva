package kz.example.currencylimit.endpoint;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.example.currencylimit.model.entity.Currency;
import kz.example.currencylimit.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kz.example.currencylimit.constants.swagger.CurrencySwaggerConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/currency")
@Tag(name = NAME_OF_CURRENCY_SERVICE,description = DESCRIPTION_OF_CURRENCY_CONTROLLER)
public class CurrencyController {

    private final CurrencyService service;

    @PostMapping
    @Operation(description = DESCRIPTION_FOR_UPDATING_CURRENCY)
    public ResponseEntity<Currency> saveCurrency(){
        return ResponseEntity.ok(service.saveOrPreviousClose());
    }
}
