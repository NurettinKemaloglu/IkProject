package com.fmss.ikrestproject.controller;

import com.fmss.ikrestproject.client.dto.request.PermissionRequestDto;
import com.fmss.ikrestproject.client.dto.responce.PermissionResponseDto;
import com.fmss.ikrestproject.service.impl.PermissionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/fmss/permission")
public class PermissionController {
    private final PermissionServiceImpl permissionService;

    public PermissionController(PermissionServiceImpl permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping()
    public ResponseEntity<PermissionResponseDto> createPermission(@RequestBody PermissionRequestDto permissionRequestDto ){
        return ResponseEntity.ok(permissionService.createPermission(permissionRequestDto));
    }
    @GetMapping
    public ResponseEntity<List<PermissionResponseDto>> getAllPermission(){
        List<PermissionResponseDto> permissionResponseDtos=permissionService.getAllPermission();
        return ResponseEntity.ok(permissionResponseDtos);
    }
    @DeleteMapping("/{permissionid}")
    public ResponseEntity<Boolean> deletePermission(@PathVariable Long permissionid){
        return  ResponseEntity.ok(permissionService.deletePermission(permissionid));
    }

}
