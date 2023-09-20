package kz.example.currencylimit.service;

import kz.example.currencylimit.model.dto.TransactionCreateDto;
import kz.example.currencylimit.model.dto.TransactionResponseDto;
import kz.example.currencylimit.model.entity.Limit;
import kz.example.currencylimit.model.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
   TransactionResponseDto createTransaction(TransactionCreateDto transaction);

   void checkToExceeded(Limit limit, Transaction transaction);

   Page<TransactionResponseDto> getAllTransactions(Pageable pageable, Boolean limitExceeded);
}
