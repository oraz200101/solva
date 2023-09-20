package kz.example.currencylimit.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Meta {

    private String symbol;
    private String interval;

    @JsonProperty("currency_base")
    private String currencyBase;

    @JsonProperty("currency_quote")
    private String currencyQuote;
    private String type;



}
