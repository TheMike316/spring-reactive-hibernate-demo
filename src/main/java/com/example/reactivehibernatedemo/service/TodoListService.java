package com.example.reactivehibernatedemo.service;

import com.example.reactivehibernatedemo.model.TodoList;
import com.example.reactivehibernatedemo.web.model.TodoListDto;
import com.example.reactivehibernatedemo.web.model.mapper.TodoListMapper;
import io.smallrye.mutiny.converters.uni.UniReactorConverters;
import lombok.RequiredArgsConstructor;
import org.hibernate.reactive.mutiny.Mutiny;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final Mutiny.SessionFactory sessionFactory;
    private final TodoListMapper todoListMapper;

    public Mono<List<TodoListDto>> getAll() {
        return sessionFactory.withSession(s ->
                s.createQuery("FROM TodoList t LEFT JOIN FETCH t.todoItems", TodoList.class)
                        .getResultList()
                        .map(l -> l.stream().map(todoListMapper::entityToDto).collect(Collectors.toList()))
        ).convert().with(UniReactorConverters.toMono());
    }
}
