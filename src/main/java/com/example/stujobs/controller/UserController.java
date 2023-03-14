package com.example.stujobs.controller;

import com.example.stujobs.pojo.User;
import com.example.stujobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @ResponseBody
    public User login(@RequestParam(value = "number" , required = false) String number,
                      @RequestParam(value = "password" , required = false) String password) {
        return userService.login(number, password);
    }


}
