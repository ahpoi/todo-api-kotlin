package com.demo.todo.api.todo

import com.demo.todo.api.todo.model.TodoKotlin
import com.demo.todo.api.todo.model.TodoKotlinDtoRequest
import com.demo.todo.api.todo.model.TodoKotlinDtoResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.notFound
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/todo")
open class TodoControllerKotlin(val service: TodoServiceKotlin) {

    @PostMapping
    fun createTodo(@RequestBody request: TodoKotlinDtoRequest): ResponseEntity<TodoKotlinDtoResponse> {
        val todo = service.saveTodo(TodoKotlin.fromDtoRequest(request))
        return status(HttpStatus.OK).body(todo.toDtoResponse())
    }

    @GetMapping("/{id}")
    fun getTodo(@PathVariable("id") id: Long): ResponseEntity<TodoKotlinDtoResponse> {
        return service.findTodo(id)?.let { todo -> status(HttpStatus.OK).body(todo.toDtoResponse()) } ?: notFound().build()
    }

}


