package kz.example.currencylimit.repository;

import kz.example.currencylimit.model.entity.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends MongoRepository<Currency, String> {
    @Query("{$sort: {dateCreate: -1}, $limit: 1}")
    Optional<Currency> findFirstByOrderByDateDesc();
    Optional<Currency> findByDateCreate(LocalDate datetime);

}
