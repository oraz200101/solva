package kz.example.currencylimit.repository;

import kz.example.currencylimit.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query("SELECT t FROM Transaction AS t WHERE (:limitExceeded IS NULL OR (:limitExceeded=t.limitExceeded))")
    List<Transaction> findAllTransactions(@Param("limitExceeded") Boolean limitExceeded);
}
