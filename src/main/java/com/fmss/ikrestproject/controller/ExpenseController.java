package com.fmss.ikrestproject.controller;

import com.fmss.ikrestproject.client.dto.request.ExpenseRequestDto;
import com.fmss.ikrestproject.client.dto.responce.ExpenseResponseDto;
import com.fmss.ikrestproject.service.ExpensesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/fmss/expense")
@AllArgsConstructor
public class ExpenseController {
    private final ExpensesService expensesService;


    @PostMapping()
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody ExpenseRequestDto expenseRequestDto ){
        return ResponseEntity.ok(expensesService.createExpense(expenseRequestDto));
    }
    @GetMapping
    public ResponseEntity<List<ExpenseResponseDto>> getExpense(){
        List<ExpenseResponseDto> expenseResponseDtos = expensesService.getExpense();
        return ResponseEntity.ok(expenseResponseDtos);
    }
    @GetMapping("/{userid}")
    public ResponseEntity<List<ExpenseResponseDto>> getAllExpense(@PathVariable Long userid){
        List<ExpenseResponseDto> expenseResponseDos=expensesService.getAllExpense(userid);
        return ResponseEntity.ok(expenseResponseDos);

    }
    @DeleteMapping("/{expenseid}")
    public  ResponseEntity<Boolean>deleteExpense(@PathVariable Long expenseid){
        return ResponseEntity.ok(expensesService.deleteExpense(expenseid));
    }



}
