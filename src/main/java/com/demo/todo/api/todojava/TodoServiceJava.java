package com.demo.todo.api.todojava;

import com.demo.todo.api.notification.MessageService;
import com.demo.todo.api.todojava.model.TodoJava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TodoServiceJava {

    private final TodoRepository todoRepository;

    private final MessageService messageService;

    @Autowired
    public TodoServiceJava(TodoRepository todoRepository,
                           MessageService messageService) {
        this.todoRepository = todoRepository;
        this.messageService = messageService;
    }

    public TodoJava saveTodo(TodoJava todo) {
        messageService.sendMessage("0441111111", todo.getName());
        return todoRepository.save(todo);
    }

    public Optional<TodoJava> findTodo(Long id) {
        return todoRepository.findTodoJavaById(id);
    }

    public Stream<TodoJava> findTodos() {
        return todoRepository.findAll().stream();
    }

}
