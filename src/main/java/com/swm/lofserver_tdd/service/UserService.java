package com.swm.lofserver_tdd.service;

import com.swm.lofserver_tdd.domain.UserEntity;
import com.swm.lofserver_tdd.domain.UserRequestDto;
import com.swm.lofserver_tdd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserEntity createUser(UserRequestDto requestDto) {
        UserEntity user = new UserEntity(requestDto);
        userRepository.save(user);
        log.info("등록한 유저 Id: " + user.getId().toString());
        return user;
    }

}
