package kz.example.currencylimit.mapper;

import kz.example.currencylimit.model.entity.Limit;
import kz.example.currencylimit.model.dto.LimitCreateDto;
import kz.example.currencylimit.model.dto.LimitResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface LimitMapper {
    @Mapping(source = "transactions",target = "transactionResponseDtos")
    LimitResponseDto mapToLimitResponseDto(Limit limit);

    List<LimitResponseDto> mapToLimitResponseDtos(List<Limit> limits);
    Limit mapToLimitEntity(LimitCreateDto limitCreateDto);


}
