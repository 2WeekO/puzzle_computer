package com.example.puzzle_computer.user;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {

    @NotEmpty(message = "이메일 작성은 필수항목입니다.")
    @Email
    private String useremail; //유저 이메일

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1; //유저 비밀번호

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2; //유저 비밀번호 확인

    @NotEmpty(message = "주소는 필수항목입니다.")
    private String useraddress; //유저 주소
    
    @Size(min = 3, max = 25)
    @NotEmpty(message = "유저 닉네임 작성은 필수항목입니다.")
    private String usernickname; //유저 닉네임

    @NotEmpty(message = "유저 이름 작성은 필수항목입니다.")
    private String username; // 유저 아이디

    @NotEmpty(message = "전화번호 작성은 필수항목입니다.")
    private String userphone; //전화번호
    
    LocalDateTime usersignupdate;
    
}
