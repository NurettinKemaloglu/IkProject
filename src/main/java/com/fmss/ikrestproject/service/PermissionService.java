package com.fmss.ikrestproject.service;

import com.fmss.ikrestproject.client.dto.request.PermissionRequestDto;
import com.fmss.ikrestproject.client.dto.request.UpdatePermissionRequestDto;
import com.fmss.ikrestproject.client.dto.responce.PermissionResponseDto;

import java.util.List;

public interface PermissionService {
    PermissionResponseDto createPermission(PermissionRequestDto permissionRequestDto);

    List<PermissionResponseDto> getAllPermission();

    void deletePermission(Long id);

    UpdatePermissionRequestDto updatePermision(Long id, UpdatePermissionRequestDto permissionRequestDto);

    PermissionResponseDto getPermissionById(Long id);

    List<PermissionResponseDto> getPermissionsByUserId(Long userId);
}
