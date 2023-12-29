package com.example.todo.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Person {
    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @Min(15)
    private int age;

}
