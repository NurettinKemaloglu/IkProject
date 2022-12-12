package com.fmss.ikrestproject.client.dto.request;

import com.fmss.ikrestproject.utils.enums.Title;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class UpdateUserRequestDto {

    @Email(regexp = "^(.+)@(.+)$", message = "Email geçerli değil lütfen bu örnekteki formatta yazalım: nurettinfmss@gmail.com")
    @NotBlank(message = "Email boş bırakılamaz")
    protected String email;
    @NotNull
    @Min(value = 0, message = "Maaş 0 dan küçük olamaz.")
    private BigDecimal salary;
    @NotNull(message = "Title boş olamaz.")
    private Title title;
    @NotNull(message = "Role boş olamaz.")
    private String role;


}
