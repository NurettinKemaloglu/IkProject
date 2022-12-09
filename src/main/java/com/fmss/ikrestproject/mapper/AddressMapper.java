package com.fmss.ikrestproject.mapper;

import com.fmss.ikrestproject.client.dto.request.UserRequestDto;
import com.fmss.ikrestproject.client.dto.responce.AddressResponseDto;
import com.fmss.ikrestproject.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressResponseDto toAdresDto(Address address) {
        final var adresDto = new AddressResponseDto();
        adresDto.setCity(address.getCity());
        adresDto.setCountry(address.getCountry());
        adresDto.setPhoneNumber(address.getPhoneNumber());
        adresDto.setAddress(address.getAddress());
        return adresDto;
    }

    public Address toAdres(UserRequestDto userRequestDto) {
        Address address = new Address();
        address.setCity(userRequestDto.getCity());
        address.setCountry(userRequestDto.getCountry());
        address.setPhoneNumber(userRequestDto.getPhoneNumber());
        address.setPostCode(userRequestDto.getPostCode());
        address.setAddress(userRequestDto.getAddress());

        return address;
    }
}
