package com.fmss.ikrestproject.mapper;

import com.fmss.ikrestproject.client.dto.request.UserRequestDto;
import com.fmss.ikrestproject.client.dto.responce.UserResponseDto;
import com.fmss.ikrestproject.model.Address;
import com.fmss.ikrestproject.model.User;
import com.fmss.ikrestproject.service.DepartmanService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    private final AddressMapper addressMapper;
    private final DepartmanService departmanService;

    public UserResponseDto toUserDto(User user) {
        final var userDto = new UserResponseDto();
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setDepartment(user.getDepartment().getName());
        userDto.setRole(user.getRole());
        userDto.setTitle(user.getTitle());
        userDto.setEmail(user.getEmail());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setLevel(user.getLevel());
        userDto.setTckn(user.getTckn());
        userDto.setUserDateOfStart(user.getUserDateOfStart());
        userDto.setSalary(user.getSalary());
        userDto.setId(user.getUserId());
        return userDto;
    }

    public User toUser(UserRequestDto userRequestDto) {
        final var user = new User();
        Address address = new Address();
        user.setBirthDate(userRequestDto.getBirthDate());
        user.setEmail(userRequestDto.getEmail());
        user.setLevel(userRequestDto.getLevel());
        user.setRole(userRequestDto.getRole());
        user.setTckn(userRequestDto.getTckn());
        user.setSalary(userRequestDto.getSalary());
        user.setDepartment(departmanService.getById(userRequestDto.getDepartment()));
        user.setTitle(userRequestDto.getTitle());
        user.setUserDateOfStart(userRequestDto.getUserDateOfStart());
        user.setName(userRequestDto.getName());
        user.setLastName(userRequestDto.getLastName());
        address.setAddress(userRequestDto.getAddress());
        address.setCity(userRequestDto.getCity());
        address.setCountry(userRequestDto.getCountry());
        address.setPostCode(userRequestDto.getPostCode());
        address.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setAddress(address);
        address.setUser(user);
        return user;

    }
}
