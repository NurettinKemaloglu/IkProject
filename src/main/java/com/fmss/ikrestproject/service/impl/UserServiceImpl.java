package com.fmss.ikrestproject.service.impl;

import com.fmss.ikrestproject.client.dto.request.UpdateUserRequestDto;
import com.fmss.ikrestproject.client.dto.request.UserRequestDto;
import com.fmss.ikrestproject.client.dto.responce.UserResponseDto;
import com.fmss.ikrestproject.exception.UserNotFoundException;
import com.fmss.ikrestproject.mapper.UserMapper;
import com.fmss.ikrestproject.model.User;
import com.fmss.ikrestproject.repository.UserRepository;
import com.fmss.ikrestproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;


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
        return users.stream().map(userMapper::toUserDto).toList();

    }

    @Override
    public UserResponseDto getByUserId(Long userid) {
        Optional<User> user = userRepository.findById(userid);
        return user.map(userMapper::toUserDto).orElseThrow(() -> new UserNotFoundException("Kullanıcı Bulunamadı ."));
    }

    @Override
    public void deleteUser(Long userid) {
        userRepository.deleteById(userid);
    }

    @Override
    public UpdateUserRequestDto updateUser(Long id, UpdateUserRequestDto userRequestDto) {
        userRepository.updateUser(userRequestDto.getEmail(), userRequestDto.getTitle(), userRequestDto.getRole(), userRequestDto.getSalary(), id);
        return userRequestDto;
    }
}
