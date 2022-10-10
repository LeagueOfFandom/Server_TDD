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

}