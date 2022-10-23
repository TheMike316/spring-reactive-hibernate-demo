package com.example.reactivehibernatedemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TodoItem> todoItems;

    // this is necessary if you want to save a new parent entity and have it's id being properly cascaded to the children
    @PrePersist
    void setForeignRelation() {
        this.todoItems.forEach(t -> t.setTodoList(this));
    }
}
