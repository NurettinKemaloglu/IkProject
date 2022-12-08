package com.fmss.ikrestproject.service.impl;

import com.fmss.ikrestproject.client.dto.request.PermissionRequestDto;
import com.fmss.ikrestproject.client.dto.request.UpdatePermissionRequestDto;
import com.fmss.ikrestproject.client.dto.responce.PermissionResponseDto;
import com.fmss.ikrestproject.exception.PermissionNotFoundException;
import com.fmss.ikrestproject.mapper.PermissionMapper;
import com.fmss.ikrestproject.model.Permission;
import com.fmss.ikrestproject.repository.PermissionRepository;
import com.fmss.ikrestproject.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    private  final PermissionMapper permissionMapper;


    @Override
    public PermissionResponseDto createPermission(PermissionRequestDto permissionRequestDto) {
        Permission permission=permissionMapper.toPermission(permissionRequestDto);
        var don = permissionRepository.save(permission);
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

    @Override
    public UpdatePermissionRequestDto updatePermision(Long id, UpdatePermissionRequestDto permissionRequestDto) {
        permissionRepository.updatePermission(permissionRequestDto.getPermissionType(),permissionRequestDto.getStartingDate(),permissionRequestDto.getEndDate(),permissionRequestDto.getDateOfReturn(),permissionRequestDto.getPermissionStatement(),id);
        return permissionRequestDto;
    }

    @Override
    public PermissionResponseDto getPermissionById(Long id) {
        Optional<Permission> permission=permissionRepository.findById(id);
        return permission.map(permissionMapper::toPermissionDto).orElseThrow(()-> new PermissionNotFoundException("İzin Kaydı Bulanamdı"));
    }

    @Override
    public List<PermissionResponseDto> getPermissionsByUserId(Long userId) {
        return permissionRepository.findAllByUser_UserId(userId).stream().map(permissionMapper::toPermissionDto).toList();
    }
}
