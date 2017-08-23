package com.demo.todojava;

import com.demo.notification.MessageService;
import com.demo.todojava.model.TodoJava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        messageService.sendMessage("41111111", todo.getName());
        return todoRepository.save(todo);
    }

    public Optional<TodoJava> findTodo(Long id) {
        return todoRepository.findTodoJavaById(id);
    }

}
