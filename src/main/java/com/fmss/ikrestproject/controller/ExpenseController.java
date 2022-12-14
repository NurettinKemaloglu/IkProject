package com.fmss.ikrestproject.controller;

import com.fmss.ikrestproject.client.dto.request.ExpenseRequestDto;
import com.fmss.ikrestproject.client.dto.request.UpdateExpenseRequestDto;
import com.fmss.ikrestproject.client.dto.responce.ExpenseResponseDto;
import com.fmss.ikrestproject.service.ExpensesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/fmss/expense")
@AllArgsConstructor
public class ExpenseController {
    private final ExpensesService expensesService;


    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody @Valid ExpenseRequestDto expenseRequestDto) {
        return ResponseEntity.ok(expensesService.createExpense(expenseRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponseDto>> getExpense() {
        List<ExpenseResponseDto> expenseResponseDtos = expensesService.getExpense();
        return ResponseEntity.ok(expenseResponseDtos);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<List<ExpenseResponseDto>> getAllExpense(@PathVariable Long userid) {
        List<ExpenseResponseDto> expenseResponseDos = expensesService.getAllExpense(userid);
        return ResponseEntity.ok(expenseResponseDos);

    }

    @GetMapping("/{expenseid}")
    public ResponseEntity<ExpenseResponseDto> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(expensesService.getExpenseById(id));
    }

    @DeleteMapping("/{expenseid}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable Long expenseid) {
        expensesService.deleteExpense(expenseid);
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<UpdateExpenseRequestDto> updateExpense(@PathVariable Long expenseId, @RequestBody UpdateExpenseRequestDto expenseRequestDto) {
        return ResponseEntity.ok(expensesService.updateExpense(expenseId, expenseRequestDto));
    }


}
