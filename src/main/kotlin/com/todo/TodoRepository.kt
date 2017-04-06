package com.todo

import com.todo.model.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository : CrudRepository<Todo, Long> {

    fun findTodoByUuid(uuid: String): Todo?

}