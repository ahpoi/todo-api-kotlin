package com.demo.todo.api.todo

import com.demo.todo.api.todo.model.TodoKotlin
import org.springframework.data.repository.CrudRepository

interface TodoRepositoryKotlin : CrudRepository<TodoKotlin, Long> {

    fun findTodoById(id: Long): TodoKotlin?

}