package com.swm.lofserver_tdd.domain;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private String email;
    private String password;
    private String nickname;
    private String profileImg;

    public UserRequestDto(String email, String password, String nickname, String profileImg) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImg = profileImg;
    }
}
