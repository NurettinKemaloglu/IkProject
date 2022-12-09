package com.fmss.ikrestproject.client.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
@Data
public class AddressRequestDto {
    @NotNull(message = "Adres id boş olamaz.")
    private Long id;
    @NotBlank(message = "şehir boş olamaz")
    private String city;
    @Pattern(regexp = "^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$", message = "Telefon numarası format hatası")
    private String phoneNumber;
    private String country;

    @Size(min = 10, max = 60, message
            = "Adres 10 ile 200 karakter arasında olmalıdır")
    private String address;
    private String postCode;

}
