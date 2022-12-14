package com.fmss.ikrestproject.mapper;

import com.fmss.ikrestproject.client.dto.request.ExpenseRequestDto;
import com.fmss.ikrestproject.client.dto.responce.ExpenseResponseDto;
import com.fmss.ikrestproject.exception.UserNotFoundException;
import com.fmss.ikrestproject.model.Expenses;
import com.fmss.ikrestproject.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class ExpensesMapper {
    private final UserRepository userRepository;

    public ExpensesMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ExpenseResponseDto toExpenseDto(Expenses expenses) {
        final var expenseDto = new ExpenseResponseDto();
        expenseDto.setSpendingAmounut(expenses.getSpendingAmounut());
        expenseDto.setSpendingStatement(expenses.getSpendingStatement());
        expenseDto.setTypeOfExpenditure(expenses.getTypeOfExpenditure());
        expenseDto.setReceiptDate(expenses.getReceiptDate());
        expenseDto.setVatPercent(expenses.getVatPercent());
        expenseDto.setUserName(expenses.getUser().getName());
        expenseDto.setLastName((expenses.getUser().getLastName()));
        expenseDto.setId(expenses.getId());

        return expenseDto;

    }

    public Expenses toExpenses(ExpenseRequestDto expenseRequestDto) {
        final var expenses = new Expenses();
        expenses.setTypeOfExpenditure(expenseRequestDto.getTypeOfExpenditure());
        expenses.setSpendingAmounut(expenseRequestDto.getSpendingAmounut());
        expenses.setReceiptDate(expenseRequestDto.getReceiptDate());
        expenses.setVatPercent(expenseRequestDto.getVatPercent());
        expenses.setSpendingStatement(expenseRequestDto.getSpendingStatement());
        expenses.setUser(userRepository.findById(expenseRequestDto.getUserid()).orElseThrow(()-> new UserNotFoundException("Kulalnıcı bulunamdı")));
        return expenses;
    }

}
