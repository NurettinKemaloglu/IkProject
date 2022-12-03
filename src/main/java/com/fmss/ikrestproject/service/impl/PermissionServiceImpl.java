package com.fmss.ikrestproject.service.impl;

import com.fmss.ikrestproject.client.dto.request.PermissionRequestDto;
import com.fmss.ikrestproject.client.dto.responce.PermissionResponseDto;
import com.fmss.ikrestproject.mapper.PermissionMapper;
import com.fmss.ikrestproject.model.Permission;
import com.fmss.ikrestproject.repository.PermıssıonRepository;
import com.fmss.ikrestproject.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermıssıonRepository permissionRepository;
    private  final PermissionMapper permissionMapper;


    @Override
    public PermissionResponseDto createPermission(PermissionRequestDto permissionRequestDto) {
        Permission permission=permissionMapper.toPermission(permissionRequestDto);
        permissionRepository.save(permission);
        return permissionMapper.toPermissionDto(permission);
    }

    @Override
    public List<PermissionResponseDto> getAllPermission() {
        return  permissionRepository.findAll().stream().map(permissionMapper::toPermissionDto).toList();

    }

    @Override
    public Boolean deletePermission(Long permissionid) {
        permissionRepository.deleteById(permissionid);
        return true;
    }
}
