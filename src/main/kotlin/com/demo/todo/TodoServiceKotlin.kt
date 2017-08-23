package com.demo.todo

import com.demo.todo.model.TodoKotlin
import org.springframework.stereotype.Component

@Component
open class TodoServiceKotlin(val repository: TodoRepositoryKotlin) {

    fun saveTodo(todo: TodoKotlin): TodoKotlin {
        return repository.save(todo)
    }

    fun findTodo(id: Long): TodoKotlin? {
        return repository.findTodoById(id)
    }

}