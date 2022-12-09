package com.fmss.ikrestproject.client.dto.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class UpdatePermissionRequestDto {
    @NotBlank(message = "İzin türü boş olunamaz")
    private String permissionType;
    @FutureOrPresent
    private LocalDate startingDate;
    @FutureOrPresent
    private LocalDate endDate;
    @FutureOrPresent
    private LocalDate dateOfReturn;
    @Size(min = 10, max = 200, message
            = "izin nedeni 10 ile 200 karakter arasında olmalıdır")
    private String permissionStatement;
}
