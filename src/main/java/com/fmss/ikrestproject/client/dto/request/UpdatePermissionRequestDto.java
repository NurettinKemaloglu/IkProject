package com.fmss.ikrestproject.client.dto.request;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class UpdatePermissionRequestDto {
    private  String permissionType;
    private LocalDate startingDate;
    private LocalDate endDate;
    private LocalDate dateOfReturn;
    private  String permissionStatement;
}
