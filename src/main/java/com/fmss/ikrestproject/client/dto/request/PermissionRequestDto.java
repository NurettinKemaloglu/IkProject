package com.fmss.ikrestproject.client.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
public class PermissionRequestDto {
    private Long userid;
    @NotBlank(message = "İzin türü boş olamaz")
    private String permissionType;

    @FutureOrPresent
    private LocalDate startingDate;
    @FutureOrPresent
    private LocalDate endDate;
    @Size(min = 10, max = 200, message
            = "izin nedeni 10 ile 200 karakter arasında olmalıdır")
    private String permissionStatement;
    @FutureOrPresent
    private LocalDate dateOfReturn;

    private BigDecimal totalDays;

}
