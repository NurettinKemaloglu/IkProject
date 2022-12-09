package com.fmss.ikrestproject.service.impl;

import com.fmss.ikrestproject.client.dto.request.UserRequestDto;
import com.fmss.ikrestproject.client.dto.responce.AddressResponseDto;
import com.fmss.ikrestproject.mapper.AddressMapper;
import com.fmss.ikrestproject.mapper.UserMapper;
import com.fmss.ikrestproject.model.Address;
import com.fmss.ikrestproject.repository.AddressRepository;
import com.fmss.ikrestproject.repository.UserRepository;
import com.fmss.ikrestproject.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    private final UserRepository userRepository;
    private final AddressMapper addressMapper;

    private final UserMapper userMapper;

    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository, AddressMapper addressMapper, UserMapper userMapper) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.addressMapper = addressMapper;
        this.userMapper = userMapper;
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
        List<AddressResponseDto> adresDtoList = adres.stream().map(addressMapper::toAdresDto).toList();
        return adresDtoList;
    }

    @Override
    public AddressResponseDto getByAdresId(Long adresid) {
        Optional<Address> adres = addressRepository.findById(adresid);
        return adres.map(addressMapper::toAdresDto).orElse(null);
    }
}
