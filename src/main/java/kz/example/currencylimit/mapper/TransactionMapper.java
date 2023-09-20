package kz.example.currencylimit.mapper;

import kz.example.currencylimit.model.entity.Transaction;
import kz.example.currencylimit.model.dto.TransactionCreateDto;
import kz.example.currencylimit.model.dto.TransactionResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface TransactionMapper {
    Transaction mapToTransactionEntity(TransactionCreateDto transactionCreateDto);

    TransactionResponseDto mapToResponseDto(Transaction transaction);

    List<TransactionResponseDto> mapToResponseDtos(List<Transaction> transactions);
}
