package com.fmss.ikrestproject.client.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Data
public class AddressRequestDto {

    private Long id;
    private  String city;
    private  String phoneNumber;
    private String country;
    private  String address;
    private  String postCode;

}
