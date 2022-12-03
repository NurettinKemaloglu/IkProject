package com.fmss.ikrestproject.repository;

import com.fmss.ikrestproject.model.Expenses;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
 List<Expenses> findAllByUser_UserId(Long userid);

}
