package com.demo.todo.api.todojava;

import com.demo.todo.api.todojava.model.TodoJava;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
interface TodoRepository extends CrudRepository<TodoJava, Long> {

    Optional<TodoJava> findTodoJavaById(Long id);

    Stream<TodoJava> streamAll();

}
