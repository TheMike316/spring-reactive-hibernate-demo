package com.example.reactivehibernatedemo.web.controller;

import com.example.reactivehibernatedemo.service.TodoListService;
import com.example.reactivehibernatedemo.web.model.TodoListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoListController {

    private final TodoListService service;

    // just retrieve the entire list of todo lists with all items for now, maybe refine stuff later
    @GetMapping
    public Mono<List<TodoListDto>> getAll() {
        return service.getAll();
    }
}
