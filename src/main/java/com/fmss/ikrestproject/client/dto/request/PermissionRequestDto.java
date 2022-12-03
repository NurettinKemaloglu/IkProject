package com.fmss.ikrestproject.client.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
public class PermissionRequestDto {
    private Long userid;
    private  String permissionType;
    private LocalDate startingDate;
    private LocalDate endDate;
    private  String permissionStatement;
    private  LocalDate dateOfReturn;
    private BigDecimal totalDays;

}
