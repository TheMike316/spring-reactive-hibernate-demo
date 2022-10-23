package com.example.reactivehibernatedemo.web.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemDto {
    private String title;
    private LocalDateTime dueDate;
}
