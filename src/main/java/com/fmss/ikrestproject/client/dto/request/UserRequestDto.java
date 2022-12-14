package com.fmss.ikrestproject.client.dto.request;

import com.fmss.ikrestproject.utils.enums.Level;
import com.fmss.ikrestproject.utils.enums.Title;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "isim boş olmamalıdır.")
    private String name;
    @Size(min = 3)
    private String lastName;
    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid. Please follow the example: turkcell@mail.com")
    @NotBlank(message = "E-posta boş olmamalıdır")
    protected String email;
    @Pattern(regexp = "^[1-9][\\d]{9}[02468]$", message = "Tc No format hatası")
    private String tckn;
    @PastOrPresent
    private LocalDate userDateOfStart;
    @NotNull
    @Min(value = 0, message = "Maaş 0 dan küçük olamaz.")
    private BigDecimal salary;
    @NotNull(message = "title boş geçilemez")
    private Title title;
    @NotNull(message = "depertman boş geçilemez")
    private Long department;
    @Past(message = "Geçersiz doğum günü")
    private LocalDate birthDate;
    private String role;
    private Level level;
    //Adress Bilgileri
    private String city;
    @Pattern(regexp = "^(05)([\\d]{2})\\s?([\\d]{3})\\s?([\\d]{2})\\s?([\\d]{2})$", message = "Telefon numarası format hatası")
    private String phoneNumber;
    private String country;

    private String postCode;

    @Size(min = 10, max = 200, message
            = "Adres 10 ile 200 karakter arasında olmalıdır")
    private String address;


}
