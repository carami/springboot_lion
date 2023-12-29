package com.example.todo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@ToString
public class Todo {
    private Long id;
    private String content;
    private boolean done;
}
