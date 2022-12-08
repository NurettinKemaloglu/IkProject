package com.fmss.ikrestproject.client.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
@Data
public class AddressRequestDto {
    @NotNull(message = "Adres id boş olamaz.")
    private Long id;
    private  String city;
    private  String phoneNumber;
    private String country;
    private  String address;
    private  String postCode;

}
