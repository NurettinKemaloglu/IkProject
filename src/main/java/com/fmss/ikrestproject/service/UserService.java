package com.fmss.ikrestproject.service;


import com.fmss.ikrestproject.client.dto.request.UpdateUserRequestDto;
import com.fmss.ikrestproject.client.dto.request.UserRequestDto;
import com.fmss.ikrestproject.client.dto.responce.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUser();

    UserResponseDto getByUserId(Long userid);


    void deleteUser(Long userid);

    UpdateUserRequestDto updateUser(Long id, UpdateUserRequestDto userRequestDto);
}
