package com.fmss.ikrestproject.service;

import com.fmss.ikrestproject.model.Department;

import java.util.List;


public interface DepartmanService  {
    List<Department> getAll();
    Department add(Department departmentRequestDto);
    Department update(Long id, Department departmentRequestDto);
    Department getById(Long id);
    void delete(Long id);
}
