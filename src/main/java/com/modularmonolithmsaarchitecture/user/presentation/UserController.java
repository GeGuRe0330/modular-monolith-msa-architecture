package com.modularmonolithmsaarchitecture.user.presentation;

import com.modularmonolithmsaarchitecture.common.response.ApiResponse;
import com.modularmonolithmsaarchitecture.user.application.UserService;
import com.modularmonolithmsaarchitecture.user.presentation.dto.LoginRequest;
import com.modularmonolithmsaarchitecture.user.presentation.dto.RegisterUserRequest;
import com.modularmonolithmsaarchitecture.user.presentation.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> register(@RequestBody RegisterUserRequest request) {
        return ApiResponse.ok(UserResponse.from(userService.register(request.toCommand())));
    }

    @PostMapping("/login")
    public ApiResponse<UserResponse> login(@RequestBody LoginRequest request) {
        return ApiResponse.ok(UserResponse.from(userService.authenticate(request.toCommand())));
    }

    @GetMapping("/{userId")
    public ApiResponse<UserResponse> getUser(@PathVariable Long userId) {
        return ApiResponse.ok(UserResponse.from(userService.getUser(userId)));
    }
}
