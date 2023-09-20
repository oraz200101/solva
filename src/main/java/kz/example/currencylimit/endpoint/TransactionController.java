package kz.example.currencylimit.endpoint;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.example.currencylimit.model.dto.TransactionCreateDto;
import kz.example.currencylimit.model.dto.TransactionResponseDto;
import kz.example.currencylimit.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kz.example.currencylimit.constants.swagger.TransactionSwaggerConstants.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transaction")
@Tag(name = NAME_OF_TRANSACTION_CONTROLLER,description = DESCRIPTION_OF_TRANSACTION_CONTROLLER)
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    @Operation(description = DESCRIPTION_OF_API_FOR_CREATING_TRANSACTION)
    public ResponseEntity<TransactionResponseDto> createTransaction(@RequestBody TransactionCreateDto transactionCreateDto) {
        return ResponseEntity.ok(transactionService.createTransaction(transactionCreateDto));
    }
    @GetMapping("/all")
    @Operation(description = DESCRIPTION_OF_API_FOR_GETTING_ALL_TRANSACTIONS)
    public ResponseEntity<Page<TransactionResponseDto>> getAll(@RequestParam(defaultValue = "0", name = "page") Integer page,
                                                               @RequestParam(defaultValue = "10", name = "count") Integer count,
                                                               @RequestParam(name = "limitExceeded", required = false) Boolean limitExceeded) {
        Pageable pageable = PageRequest.of(page, count);
        return ResponseEntity.ok(transactionService.getAllTransactions(pageable, limitExceeded));
    }

}
