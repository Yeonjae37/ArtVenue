package com.database.artvenue.service;

import com.database.artvenue.api.code.status.ErrorStatus;
import com.database.artvenue.api.exception.handler.UserHandler;
import com.database.artvenue.converter.CafeConverter;
import com.database.artvenue.domain.Cafe;
import com.database.artvenue.domain.User;
import com.database.artvenue.repository.CafeRepository;
import com.database.artvenue.repository.UserRepository;
import com.database.artvenue.web.dto.cafe.CafeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeService {
    private final CafeRepository cafeRepository;
    private final UserRepository userRepository;

    @Autowired
    public CafeService(CafeRepository cafeRepository, UserRepository userRepository) {
        this.cafeRepository = cafeRepository;
        this.userRepository = userRepository;
    }

    public void addCafe(CafeRequestDTO.CafeDTO request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus._USER_NOT_FOUND));
        Cafe cafe = CafeConverter.toEntity(request, user);
        cafeRepository.save(cafe);
    }
}
