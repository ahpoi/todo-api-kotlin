package com.demo.todo

import com.demo.todo.model.TodoKotlin
import org.springframework.data.repository.CrudRepository

interface TodoRepositoryKotlin : CrudRepository<TodoKotlin, Long> {

    fun findTodoById(id: Long): TodoKotlin?

}