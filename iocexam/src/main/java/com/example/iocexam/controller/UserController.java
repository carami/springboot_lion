package com.example.iocexam.controller;

import com.example.iocexam.domain.User;
import com.example.iocexam.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void joinUser(){
        //클라이언트에서 보낸 값을 이용..

        User user = new User();
        user.setEmail("carami@nate.com");
        user.setName("강경미");
        user.setPassowrd("12344");

        userService.joinUser(user);
    }
}
