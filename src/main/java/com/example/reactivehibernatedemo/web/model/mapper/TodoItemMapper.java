package com.example.reactivehibernatedemo.web.model.mapper;

import com.example.reactivehibernatedemo.model.TodoItem;
import com.example.reactivehibernatedemo.web.model.TodoItemDto;
import org.springframework.stereotype.Component;

@Component
public class TodoItemMapper {

    public TodoItemDto entityToDto(TodoItem entity) {
        return TodoItemDto.builder()
                .title(entity.getTitle())
                .dueDate(entity.getDueDate())
                .build();
    }
}
