package com.fmss.ikrestproject.service.impl;

import com.fmss.ikrestproject.client.dto.request.ExpenseRequestDto;
import com.fmss.ikrestproject.client.dto.request.UpdateExpenseRequestDto;
import com.fmss.ikrestproject.client.dto.responce.ExpenseResponseDto;
import com.fmss.ikrestproject.exception.ExpenseNotFoundException;
import com.fmss.ikrestproject.mapper.ExpensesMapper;
import com.fmss.ikrestproject.mapper.UserMapper;
import com.fmss.ikrestproject.model.Expenses;
import com.fmss.ikrestproject.repository.ExpensesRepository;
import com.fmss.ikrestproject.repository.UserRepository;
import com.fmss.ikrestproject.service.ExpensesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpensesServiceImpl implements ExpensesService {
    private final ExpensesRepository expensesRepository;
    private final UserRepository userRepository;
    private final ExpensesMapper expensesMapper;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public ExpenseResponseDto createExpense(ExpenseRequestDto expenseRequestDto) {
        Expenses expenses = expensesMapper.toExpenses(expenseRequestDto);
        expensesRepository.save(expenses);
        return expensesMapper.toExpenseDto(expenses);
    }

    @Override
    public List<ExpenseResponseDto> getAllExpense(Long userid) {
        return expensesRepository.findAllByUser_UserId(userid).stream().map(expensesMapper::toExpenseDto).toList();
    }

    @Override
    public Boolean deleteExpense(Long expenseid) {
        expensesRepository.deleteById(expenseid);
        return true;
    }

    @Override
    public List<ExpenseResponseDto> getExpense() {
        List<Expenses> users = expensesRepository.findAll();
        List<ExpenseResponseDto> expenseResponseDtoList = users.stream().map(expensesMapper::toExpenseDto).toList();
        return expenseResponseDtoList;

    }

    @Override
    public ExpenseResponseDto getExpenseById(Long id) {
        Optional<Expenses> expenses = expensesRepository.findById(id);
        return expenses.map(expensesMapper::toExpenseDto).orElseThrow(() -> new ExpenseNotFoundException("Harcama bulunamadı"));
    }

    @Override
    public UpdateExpenseRequestDto updateExpense(Long expenseId, UpdateExpenseRequestDto expenseRequestDto) {
        expensesRepository.updateExpense(expenseRequestDto.getReceiptDate(),expenseRequestDto.getSpendingAmounut(),expenseRequestDto.getSpendingStatement(),expenseRequestDto.getTypeOfExpenditure(),expenseRequestDto.getVatPercent(),expenseId);
        return expenseRequestDto;
    }
}
