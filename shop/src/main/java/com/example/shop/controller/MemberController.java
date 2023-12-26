package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/add")
    public String addForm(){
        return "memberForm";
    }

    @PostMapping("/add")
    public String add(@RequestParam String name, Model model){
        model.addAttribute("aa", name);
        return "memberView";
    }
}
