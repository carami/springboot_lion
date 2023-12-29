package com.example.todo.service;

import com.example.todo.domain.Todo;
import com.example.todo.repository.TodoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoDao todoDao;
    public List<Todo> getTodos(){
        return todoDao.findAll();
    }
}
