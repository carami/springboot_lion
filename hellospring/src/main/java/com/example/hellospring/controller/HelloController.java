package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello spring boot!!!";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
//    @ResponseBody
    public String hi(){
        return "hi~~~carami!!!";
    }
}
