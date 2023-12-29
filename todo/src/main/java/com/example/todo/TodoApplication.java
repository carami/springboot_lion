package com.example.todo;

import com.example.todo.domain.Todo;
import com.example.todo.repository.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Autowired
	TodoDao todoDao;
	@Override
	public void run(String... args) throws Exception {
		List<Todo> todos =  todoDao.findAll();
		System.out.println(todos.size());
		for(Todo todo : todos){
			System.out.println(todo);
		}
	}
}
