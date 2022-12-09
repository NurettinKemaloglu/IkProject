package com.fmss.ikrestproject.service.impl;

import com.fmss.ikrestproject.model.Department;
import com.fmss.ikrestproject.repository.DepartmanRepository;
import com.fmss.ikrestproject.service.DepartmanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmanServiceImpl implements DepartmanService {
    private final DepartmanRepository departmanRepository;

    public DepartmanServiceImpl(DepartmanRepository departmanRepository) {
        this.departmanRepository = departmanRepository;
    }

    @Override
    public List<Department> getAll() {
        return departmanRepository.findAll();
    }

    @Override
    public Department add(Department department) {
        return departmanRepository.save(department);
    }

    @Override
    public Department update(Long id, Department department) {
        Department department1 = departmanRepository.findById(id).get();
        department1.setName(department.getName());
        return departmanRepository.save(department1);
    }

    @Override
    public Department getById(Long id) {
        return departmanRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        departmanRepository.deleteById(id);
    }
}
