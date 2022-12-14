package com.fmss.ikrestproject.service.impl;

import com.fmss.ikrestproject.client.dto.request.UserRequestDto;
import com.fmss.ikrestproject.client.dto.responce.AddressResponseDto;
import com.fmss.ikrestproject.mapper.AddressMapper;
import com.fmss.ikrestproject.model.Address;
import com.fmss.ikrestproject.repository.AddressRepository;

import com.fmss.ikrestproject.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;


    private final AddressMapper addressMapper;


    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;

        this.addressMapper = addressMapper;
    }

    @Override
    public Address createAdres(UserRequestDto userRequestDto) {
        Address address = addressMapper.toAdres(userRequestDto);
        Address savedAddress = addressRepository.save(address);
        return (savedAddress);
    }

    @Override
    public List<AddressResponseDto> getAllAdres() {
        List<Address> adres = addressRepository.findAll();
        return adres.stream().map(addressMapper::toAdresDto).toList();
        
    }

    @Override
    public AddressResponseDto getByAdresId(Long adresid) {
        Optional<Address> adres = addressRepository.findById(adresid);
        return adres.map(addressMapper::toAdresDto).orElse(null);
    }
}
