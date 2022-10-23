package com.example.reactivehibernatedemo.bootstrap;

import com.example.reactivehibernatedemo.model.TodoItem;
import com.example.reactivehibernatedemo.model.TodoList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.reactive.mutiny.Mutiny;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataBootstrap implements InitializingBean {

    private final Mutiny.SessionFactory sessionFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        var list = TodoList.builder().name("basic list")
                .todoItems(List.of(
                        TodoItem.builder().title("feed cat").dueDate(LocalDateTime.now().plus(3, ChronoUnit.HOURS)).build(),
                        TodoItem.builder().title("do laundry").dueDate(LocalDateTime.now().plus(1, ChronoUnit.DAYS)).build(),
                        TodoItem.builder().title("call mom").dueDate(LocalDateTime.now().plus(1, ChronoUnit.HOURS)).build()
                ))
                .build();

        sessionFactory.withTransaction((session -> {
            log.info("persisting basic list");
            return session.persist(list);
        })).await().indefinitely();
    }
}
