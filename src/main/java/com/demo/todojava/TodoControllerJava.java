package com.demo.todojava;

import com.demo.todojava.model.TodoJava;
import com.demo.todojava.model.TodoJavaDtoRequest;
import com.demo.todojava.model.TodoJavaDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("java/todo")
public class TodoControllerJava {

    @Autowired
    private TodoServiceJava todoServiceJava;

    @PostMapping
    public ResponseEntity<TodoJavaDtoResponse> createTodo(@RequestBody TodoJavaDtoRequest request) {
        final TodoJava todo = TodoJava.fromDtoRequest(request);
        final TodoJava savedTodo = todoServiceJava.saveTodo(todo);
        return new ResponseEntity<>(savedTodo.toDtoResponse(), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoJavaDtoResponse> getTodo(@PathVariable("id") Long id) {
        return todoServiceJava.findTodo(id)
                .map(todoJava -> new ResponseEntity<>(todoJava.toDtoResponse(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
