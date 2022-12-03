package com.fmss.ikrestproject.service.impl;

import com.fmss.ikrestproject.client.dto.request.UpdateUserRequestDto;
import com.fmss.ikrestproject.client.dto.request.UserRequestDto;
import com.fmss.ikrestproject.client.dto.responce.UserResponseDto;
import com.fmss.ikrestproject.exception.UserNotFoundException;
import com.fmss.ikrestproject.mapper.UserMapper;
import com.fmss.ikrestproject.model.User;
import com.fmss.ikrestproject.repository.UserRepository;
import com.fmss.ikrestproject.service.AddressService;
import com.fmss.ikrestproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressService addressService;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, AddressService addressService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.addressService = addressService;

    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.toUser(userRequestDto);
        userRepository.save(userMapper.toUser(userRequestDto));
        return userMapper.toUserDto(user);


    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userDtoList = users.stream().map(userMapper::toUserDto).toList();
        return userDtoList;

    }

    @Override
    public UserResponseDto getByUserId(Long userid) {
        Optional<User> user = userRepository.findById(userid);
        return user.map(userMapper::toUserDto).orElse(null);
    }

    @Override
    public Boolean deleteUser(Long userid) {
        userRepository.deleteById(userid);
        return true;
    }

    @Override
    public UserResponseDto UpdateUser(Long id, UpdateUserRequestDto userRequestDto) {
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(user -> {
            user.setSalary(userRequestDto.getSalary());
            user.setEmail(userRequestDto.getEmail());
            user.setTitle(userRequestDto.getTitle());
            user.setRole(userRequestDto.getRole());
            userRepository.save(user);
        });
        return userOptional.map(userMapper::toUserDto)
                .orElseThrow(() -> new UserNotFoundException("User bulunamadı"));
    }
}
