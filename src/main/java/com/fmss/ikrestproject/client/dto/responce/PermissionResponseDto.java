package com.fmss.ikrestproject.client.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionResponseDto {
    private Long id;

    private String userName;
    private String lastName;
    private String permissionType;
    private LocalDate startingDate;
    private LocalDate dateOfReturn;
    private String permissionStatement;
    private LocalDate endDate;
}
