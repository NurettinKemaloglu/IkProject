package com.fmss.ikrestproject.client.dto.request;
import com.fmss.ikrestproject.utils.enums.Level;
import com.fmss.ikrestproject.utils.enums.Title;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@RequiredArgsConstructor
public class UserRequestDto {
    private  String name;
    private  String lastName;
    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid. Please follow the example: turkcell@mail.com")
    @NotBlank(message = "E-posta boş olmamalıdır")
    protected String email;
    private String tckn;
    private LocalDate userDateOfStart;
    @NotNull
    @Min(value = 0, message = "Maaş 0 dan küçük olamaz.")
    private BigDecimal salary;
    private Title title;
    private Long department;
    private LocalDate birthDate;
    private String role;
    private Level level;
    //Adress Bilgileri
    private  String city;
    private  String phoneNumber;
    private String country;
    private  String postCode;
    private  String address;


}
