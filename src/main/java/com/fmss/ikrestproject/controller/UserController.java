package com.fmss.ikrestproject.controller;

import com.fmss.ikrestproject.client.dto.request.UpdateUserRequestDto;
import com.fmss.ikrestproject.client.dto.request.UserRequestDto;
import com.fmss.ikrestproject.client.dto.responce.UserResponseDto;
import com.fmss.ikrestproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/fmss/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.createUser(userRequestDto));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUser() {
        List<UserResponseDto> userDtos = userService.getAllUser();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getByUserId(userId));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userid) {
       userService.deleteUser(userid);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserRequestDto> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.UpdateUser(id, userRequestDto));

    }
}
