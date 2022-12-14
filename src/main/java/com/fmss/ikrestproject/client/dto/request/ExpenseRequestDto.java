package com.fmss.ikrestproject.client.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseRequestDto {
    private Long userid;
    @NotBlank(message = "Harcama türü boş olamaz ")
    private String typeOfExpenditure;
    @NotNull(message = "Harcama tutarı bol olamaz")
    private BigDecimal spendingAmounut;
    @PastOrPresent
    private LocalDate receiptDate;

    @NotNull(message = "Vergi oranı boş geçilemez")
    private int vatPercent;

    @Size(min = 10, max = 200, message
            = "Harcama nedeni 10 ile 200 karakter arasında olmalıdır")
    private String spendingStatement;

}


