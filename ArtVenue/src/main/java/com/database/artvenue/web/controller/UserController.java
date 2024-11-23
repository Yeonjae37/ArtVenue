package com.database.artvenue.web.controller;

import com.database.artvenue.api.ApiResponse;
import com.database.artvenue.api.code.status.SuccessStatus;
import com.database.artvenue.repository.UserRepository;
import com.database.artvenue.service.UserService;
import com.database.artvenue.web.dto.user.UserRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @PostMapping("/join")
    @Operation(summary = "회원가입", description = "유저 회원가입")
    public ApiResponse join(@RequestBody UserRequestDTO.SignUpDTO request) {
        userService.join(request);
        return ApiResponse.of(SuccessStatus._POST_USER_OK, null);
    }
    @GetMapping("/login")
    @Operation(summary = "로그인", description = "유저 로그인")
    public ApiResponse login(@RequestParam String name, @RequestParam String password) {
        UserRequestDTO.LoginDTO loginDTO = new UserRequestDTO.LoginDTO(name, password);
        userService.login(loginDTO);
        return ApiResponse.of(SuccessStatus._GET_USER_OK, null);
    }
}
