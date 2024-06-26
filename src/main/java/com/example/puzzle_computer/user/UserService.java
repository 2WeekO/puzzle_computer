package com.example.puzzle_computer.user;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public WebUser create(String useremail, String userpassword, String useraddress, String usernickname, String username, String userphone, LocalDateTime usersignupdate) {
        WebUser user = new WebUser();
        user.setUseremail(useremail);
        user.setUsername(username);
        user.setUsernickname(usernickname);
        user.setUserpassword(passwordEncoder.encode(userpassword));
        user.setUserphone(userphone);
        user.setUseraddress(useraddress);
        user.setUsersignupdate(LocalDateTime.now());
        this.userRepository.save(user);
        return user;
    }

    public WebUser getUser(String username) {
        Optional<WebUser> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}