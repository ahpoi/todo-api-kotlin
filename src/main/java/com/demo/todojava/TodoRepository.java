package com.demo.todojava;

import com.demo.todojava.model.TodoJava;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface TodoRepository extends CrudRepository<TodoJava, Long> {

    Optional<TodoJava> findTodoJavaById(Long id);

}
