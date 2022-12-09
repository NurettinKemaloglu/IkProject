package com.fmss.ikrestproject.repository;

import com.fmss.ikrestproject.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
 List<Expenses> findAllByUser_UserId(Long userid);
 @Modifying
 @Transactional
 @Query(value = "update  Expenses e  " +
         "set e.receiptDate=:reciptDate, " +
         "e.spendingAmounut=:spendingAmount, " +
         "e.spendingStatement=:spendingStatement, " +
         "e.typeOfExpenditure=:typeOfExpenditure, " +
         "e.vatPercent=:vatPercent " +
         "where e.id=:id"
 )
 void updateExpense(LocalDate reciptDate, BigDecimal spendingAmount, String spendingStatement ,String typeOfExpenditure,int vatPercent,Long id );


}
