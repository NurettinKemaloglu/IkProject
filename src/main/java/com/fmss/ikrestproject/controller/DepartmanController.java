package com.fmss.ikrestproject.controller;

import com.fmss.ikrestproject.model.Department;
import com.fmss.ikrestproject.service.DepartmanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/fmss/departman")
public class DepartmanController {

    private final DepartmanService departmanService;

    public DepartmanController(DepartmanService departmanService) {
        this.departmanService = departmanService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        return new ResponseEntity<>(departmanService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable Long id) {
        return new ResponseEntity<>(departmanService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> add(@RequestBody Department department) {
        return new ResponseEntity<>(departmanService.add(department), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        departmanService.delete(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department) {
        return new ResponseEntity<>(departmanService.update(id, department), HttpStatus.OK);
    }
}
