package com.example.demo.service;

import com.example.demo.exception.NoDataException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DateTimeException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUser(String id, String pw) {
        return userRepository.findByUserIdAndUserPassword(id, pw)
                .orElseThrow(() -> new NoDataException("아이디 비밀번호를 확인하세요"));
    }

    @Transactional
    public User saveUser(String id, String pw, String name) {
        return userRepository.save(User.builder()
                .userId(id)
                .userPassword(pw)
                .userName(name).build());
    }
}
