package com.fmss.ikrestproject.repository;

import com.fmss.ikrestproject.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
 List<Expenses> findAllByUser_UserId(Long userid);

}
