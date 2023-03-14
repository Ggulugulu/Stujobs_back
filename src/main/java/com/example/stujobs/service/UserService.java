package com.example.stujobs.service;

import com.example.stujobs.mapper.UserMapper;
import com.example.stujobs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public User login(String number, String password) {
        return mapper.selectByNumberAndPassword(number, password);
    }

}
