package com.fmss.ikrestproject.repository;

import com.fmss.ikrestproject.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmanRepository extends JpaRepository<Department,Long> {
}
