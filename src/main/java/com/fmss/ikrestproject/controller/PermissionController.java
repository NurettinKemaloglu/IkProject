package com.fmss.ikrestproject.controller;

import com.fmss.ikrestproject.client.dto.request.PermissionRequestDto;
import com.fmss.ikrestproject.client.dto.request.UpdatePermissionRequestDto;
import com.fmss.ikrestproject.client.dto.responce.PermissionResponseDto;
import com.fmss.ikrestproject.service.impl.PermissionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<PermissionResponseDto> createPermission(@RequestBody @Valid PermissionRequestDto permissionRequestDto) {
        return ResponseEntity.ok(permissionService.createPermission(permissionRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<PermissionResponseDto>> getAllPermission() {
        List<PermissionResponseDto> permissionResponseDtos = permissionService.getAllPermission();
        return ResponseEntity.ok(permissionResponseDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PermissionResponseDto>> getPermissionsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(permissionService.getPermissionsByUserId(userId));
    }

    @GetMapping("/{permissionId}")
    public ResponseEntity<PermissionResponseDto> getPermissionById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.getPermissionById(id));
    }

    @DeleteMapping("/{permissionId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePermission(@PathVariable Long permissionid) {
       permissionService.deletePermission(permissionid);
    }

    @PutMapping("/{permissionId}")
    public ResponseEntity<UpdatePermissionRequestDto> updatePermission(@PathVariable Long permissionId, @RequestBody UpdatePermissionRequestDto permissionRequestDto) {
        return ResponseEntity.ok(permissionService.updatePermision(permissionId, permissionRequestDto));
    }
}
