package com.example.todo.controller;

import com.example.todo.domain.Todo;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public String todo(Model model){
        List<Todo> todos = todoService.getTodos();
        model.addAttribute("todos",todos);
        return "todo";
    }
}
