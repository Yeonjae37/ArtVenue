package com.database.artvenue.service;

import com.database.artvenue.api.code.status.ErrorStatus;
import com.database.artvenue.converter.UserConverter;
import com.database.artvenue.domain.User;
import com.database.artvenue.repository.UserRepository;
import com.database.artvenue.web.dto.user.UserRequestDTO;
import org.springframework.stereotype.Service;
import com.database.artvenue.api.exception.handler.UserHandler;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void join(UserRequestDTO.SignUpDTO request) {
        User newUser = UserConverter.toEntity(request);
        userRepository.save(newUser);
    }

    public void login(UserRequestDTO.LoginDTO request) {
        User user = userRepository.findByName(request.getName())
                .orElseThrow(() -> new UserHandler(ErrorStatus._USER_NOT_FOUND));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new UserHandler(ErrorStatus._INVALID_PASSWORD);
        }
        System.out.println("로그인 성공: " + user.getName());
    }
}