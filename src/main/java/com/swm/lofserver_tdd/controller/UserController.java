package com.swm.lofserver_tdd.controller;

import com.swm.lofserver_tdd.domain.UserEntity;
import com.swm.lofserver_tdd.domain.UserRequestDto;
import com.swm.lofserver_tdd.exception.ErrorResponseDto;
import com.swm.lofserver_tdd.repository.UserRepository;
import com.swm.lofserver_tdd.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping("/users/{id}")
    public UserEntity getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponseDto illegalArgumentExHandle(IllegalArgumentException e) {
        log.error("[exceptionHandle] ex", e.getMessage());
        return new ErrorResponseDto("BAD", e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalStateException.class)
    public ErrorResponseDto illegalStateExceptionExHandle(IllegalStateException e) {
        log.error("[exceptionHandle] ex", e.getMessage());
        return new ErrorResponseDto("BAD", e.getMessage());
    }
}

