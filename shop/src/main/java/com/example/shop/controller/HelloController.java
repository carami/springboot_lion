package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hi")
    @ResponseBody
    public String hi(){
        return "hi~~";
    }

    @GetMapping("/hello")
    @ResponseBody
    public List<String> hello(){
        List<String> names = new ArrayList<>();
        names.add("kang");
        names.add("kim");
        names.add("hong");
        names.add("lee");
        return names;

    }

}
