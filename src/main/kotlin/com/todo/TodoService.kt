package com.todo

import com.todo.model.Todo
import org.springframework.stereotype.Component

@Component
open class TodoService(val repository: TodoRepository) {

    fun saveTodo(todo: Todo): Todo {
        return repository.save(todo)
    }

    fun findTodo(uuid: String): Todo? {
        return repository.findTodoByUuid(uuid)
    }

}