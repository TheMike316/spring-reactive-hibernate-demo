package com.example.reactivehibernatedemo.config;

import org.hibernate.reactive.mutiny.Mutiny;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Persistence;

@Configuration
public class HibernateConfig {

    @Bean
    Mutiny.SessionFactory sessionFactory() {
        return Persistence.createEntityManagerFactory("todo list").unwrap(Mutiny.SessionFactory.class);
    }
}
