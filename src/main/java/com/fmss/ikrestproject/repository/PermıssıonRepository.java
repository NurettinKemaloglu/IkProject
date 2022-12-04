package com.fmss.ikrestproject.repository;

import com.fmss.ikrestproject.model.Expenses;
import com.fmss.ikrestproject.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface PermıssıonRepository extends JpaRepository<Permission,Long> {



    List<Expenses> findAllByUser_UserId(Long userid);

}
