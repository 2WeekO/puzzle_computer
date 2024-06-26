package com.example.puzzle_computer.user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class WebUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid; // 유저 고유 ID
    
    @Email
    private String useremail; //유저 이메일

    @Column(unique = true)
    private String userpassword; //유저 비밀번호

    private String useraddress; //유저 주소
    
    @Column(length = 10)
    private String usernickname; //유저 닉네임

    private String username; // 유저 이름

    private String userphone; //전화번호
    
    private LocalDateTime usersignupdate; // 가입 날짜
}