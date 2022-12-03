package com.fmss.ikrestproject.service;

import com.fmss.ikrestproject.client.dto.request.UserRequestDto;
import com.fmss.ikrestproject.client.dto.responce.AddressResponseDto;
import com.fmss.ikrestproject.model.Address;

import java.util.List;

public interface AddressService {
    Address createAdres(UserRequestDto userRequestDto);

    List<AddressResponseDto> getAllAdres();

    AddressResponseDto getByAdresId(Long adresid);
}
