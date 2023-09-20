package kz.example.currencylimit.repository;

import kz.example.currencylimit.model.entity.Limit;
import kz.example.currencylimit.model.enums.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LimitRepository extends JpaRepository<Limit, Long> {
    @Query("SELECT l FROM Limit l WHERE " +
            "EXTRACT(MONTH FROM l.dateTimeCreate)=:monthNumber " +
            "AND l.expenseCategory=:category")
    Optional<Limit> findByActualAndMonth(Integer monthNumber, ExpenseCategory category);

    @Query("select l from Limit l where l.actual = TRUE AND EXTRACT(MONTH FROM l.dateTimeCreate)<:monthNumber ")
    Optional<Limit> findByActualTrueExpiredMonth(Integer monthNumber);

    List<Limit> findAll();

}
