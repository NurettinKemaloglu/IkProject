package com.fmss.ikrestproject.mapper;


import com.fmss.ikrestproject.client.dto.request.PermissionRequestDto;
import com.fmss.ikrestproject.client.dto.responce.PermissionResponseDto;
import com.fmss.ikrestproject.exception.UserNotFoundException;
import com.fmss.ikrestproject.model.Permission;
import com.fmss.ikrestproject.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {
    private final UserRepository userRepository;

    public PermissionMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PermissionResponseDto toPermissionDto(Permission permission) {
        final var permissionDto = new PermissionResponseDto();
        permissionDto.setStartingDate(permission.getStartingDate());
        permissionDto.setEndDate(permission.getEndDate());
        permissionDto.setPermissionType(permission.getPermissionType());
        permissionDto.setDateOfReturn(permission.getDateOfReturn());
        permissionDto.setPermissionStatement(permission.getPermissionStatement());
        permissionDto.setUserName(permission.getUser().getName());
        permissionDto.setLastName(permission.getUser().getLastName());
        permissionDto.setId(permission.getId());
        return permissionDto;
    }

    public Permission toPermission(PermissionRequestDto permissionRequestDto) {
        final var permission = new Permission();
        permission.setPermissionStatement(permissionRequestDto.getPermissionStatement());
        permission.setPermissionType(permissionRequestDto.getPermissionType());
        permission.setStartingDate(permissionRequestDto.getStartingDate());
        permission.setEndDate(permissionRequestDto.getEndDate());
        permission.setDateOfReturn(permissionRequestDto.getDateOfReturn());
        permission.setTotalDays(permissionRequestDto.getTotalDays());
        permission.setUser(userRepository.findById(permissionRequestDto.getUserid()).orElseThrow(()->new  UserNotFoundException("Kullanıcı Bulunamadı")));
        return permission;
    }
}
