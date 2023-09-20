package kz.example.currencylimit.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customConfiguration(@Value("${springdoc.version}") String appVersion){
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Currency Limit API").version(appVersion)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }
}
