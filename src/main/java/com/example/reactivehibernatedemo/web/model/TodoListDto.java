package com.example.reactivehibernatedemo.web.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoListDto {
    private String name;
    private List<TodoItemDto> items;
}
