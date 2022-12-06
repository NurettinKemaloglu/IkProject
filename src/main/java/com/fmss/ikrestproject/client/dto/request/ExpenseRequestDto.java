package com.fmss.ikrestproject.client.dto.request;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class ExpenseRequestDto {
    private Long userid;

    private String typeOfExpenditure;

    private BigDecimal spendingAmounut;

    private LocalDate receiptDate;


    private int vatPercent;



    private String spendingStatement;

}


