package com.swm.lofserver_tdd.service;

import com.swm.lofserver_tdd.domain.UserEntity;
import com.swm.lofserver_tdd.domain.UserRequestDto;
import com.swm.lofserver_tdd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserEntity createUser(UserRequestDto requestDto) {
        validateDuplicateUser(requestDto);

        UserEntity user = new UserEntity(requestDto);
        userRepository.save(user);
        log.info("등록된 유저 Id: " + user.getId().toString());
        return user;
    }

    private void validateDuplicateUser(UserRequestDto requestDto){
        List<UserEntity> findUsers = userRepository.findByEmail(requestDto.getEmail());
        if(!findUsers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
