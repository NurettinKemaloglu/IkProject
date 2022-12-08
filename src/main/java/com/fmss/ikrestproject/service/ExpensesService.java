package com.fmss.ikrestproject.service;

import com.fmss.ikrestproject.client.dto.request.ExpenseRequestDto;
import com.fmss.ikrestproject.client.dto.responce.ExpenseResponseDto;

import java.util.List;

public interface ExpensesService {
    ExpenseResponseDto createExpense(ExpenseRequestDto expenseRequestDto);

    List<ExpenseResponseDto> getAllExpense(Long userid);

    Boolean deleteExpense(Long expenseid);

    List<ExpenseResponseDto> getExpense();

    ExpenseResponseDto getExpenseById(Long id);
}
