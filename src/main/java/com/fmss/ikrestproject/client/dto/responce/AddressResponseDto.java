package com.fmss.ikrestproject.client.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto {
    private String city;
    private  String country;
    private  String phoneNumber;
    private  String address;
}
