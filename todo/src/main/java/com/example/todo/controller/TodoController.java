package com.example.todo.controller;

import com.example.todo.domain.Todo;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/update")
    public String update(@RequestParam Long id){
        todoService.updateTodo(id);
        return "redirect:/todo";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id){

        todoService.deleteTodo(id);
        return "redirect:/todo";
    }

    @PostMapping("/add")
    public String add(@RequestParam String content){
        todoService.addTodo(content);
        return "redirect:/todo";
    }
}
