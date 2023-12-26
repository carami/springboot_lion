package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String hi(String name, Model model) {
        System.out.println(name);
        model.addAttribute("name", name);
        return "hi";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
