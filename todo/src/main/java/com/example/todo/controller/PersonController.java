package com.example.todo.controller;

import com.example.todo.domain.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @GetMapping("/")
    public String form(Person person){
        return "person";
    }

    @PostMapping("/")
    public String save(@Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "person";
        }
        return "redirect:/todo";
    }

}
