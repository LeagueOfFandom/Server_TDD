package com.swm.lofserver_tdd.domain;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long Id;

    @Column(name="token")
    private String token; //fcm token

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="nickname")
    private String nickname;

    @Column(name="profile_img")
    private String profileImg;

//    @Type(type="json")
//    @Column(name="league_list", columnDefinition = "json")
//    private List<Long> leagueList = new ArrayList<>();
//
//    @Type(type="json")
//    @Column(name="team_list", columnDefinition = "json")
//    private List<Long> teamList = new ArrayList<>();

    //회원 등록 시 이용
    public UserEntity(UserRequestDto requestDto){
        this.email = requestDto.getEmail();
        this.password = requestDto.getPassword();
        this.nickname = requestDto.getNickname();
        this.profileImg = requestDto.getProfileImg();
    }
}
