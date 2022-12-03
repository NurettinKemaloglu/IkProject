package com.fmss.ikrestproject.service;

import com.fmss.ikrestproject.client.dto.request.PermissionRequestDto;
import com.fmss.ikrestproject.client.dto.responce.PermissionResponseDto;

import java.util.List;

public interface PermissionService {
    PermissionResponseDto createPermission(PermissionRequestDto permissionRequestDto);

    List<PermissionResponseDto> getAllPermission();

    Boolean deletePermission(Long id);
}
