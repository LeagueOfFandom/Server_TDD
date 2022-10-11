package com.swm.lofserver_tdd.service;

import com.swm.lofserver_tdd.domain.UserEntity;
import com.swm.lofserver_tdd.domain.UserRequestDto;
import com.swm.lofserver_tdd.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired EntityManager em;

    @Test
    void 회원가입() throws Exception {
        //given
        UserRequestDto userRequestDto = new UserRequestDto("hello@gmail.com", "hello1234", "hello", "hello.png");

        //when
        UserEntity saveUser = userService.createUser(userRequestDto);
        Long saveId = saveUser.getId();

        // then
        em.flush();
        assertEquals(saveUser.getEmail(), userRequestDto.getEmail());
    }

    @Test
    void 중복회원예외(){
        //given
        //그냥 바로 userEntity에 유저를 넣는 것인지
        //아니면 userRequestDto로 넣어서 실제 서비스처럼 구현하는지
        UserRequestDto userRequestDto1 = new UserRequestDto("hello@gmail.com", "hello1234", "hello", "hello.png");
        UserRequestDto userRequestDto2 = new UserRequestDto("hello@gmail.com", "huuu1234", "hello2", "hello2.png");

        //when
        userService.createUser(userRequestDto1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            userService.createUser(userRequestDto2);
        });

        //then
        assertEquals("이미 존재하는 회원입니다.", e.getMessage());
    }
}