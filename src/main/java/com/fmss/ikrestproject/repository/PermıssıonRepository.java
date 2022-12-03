package com.fmss.ikrestproject.repository;

import com.fmss.ikrestproject.model.Expenses;
import com.fmss.ikrestproject.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermıssıonRepository extends JpaRepository<Permission,Long> {



    List<Expenses> findAllByUser_UserId(Long userid);

}
