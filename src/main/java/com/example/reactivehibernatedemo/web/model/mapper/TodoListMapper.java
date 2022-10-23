package com.example.reactivehibernatedemo.web.model.mapper;

import com.example.reactivehibernatedemo.model.TodoList;
import com.example.reactivehibernatedemo.web.model.TodoListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TodoListMapper {

    private final TodoItemMapper itemMapper;

    public TodoListDto entityToDto(TodoList entity) {
        return TodoListDto.builder()
                .name(entity.getName())
                .items(
                        entity.getTodoItems().stream()
                                .map(itemMapper::entityToDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
