package com.fmss.ikrestproject.client.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseDto {

    private Long id;
    private String typeOfExpenditure;
    private BigDecimal spendingAmounut;
    private String spendingStatement;
    private LocalDate receiptDate;
    private int vatPercent;
    private String userName;
    private String lastName;
}
