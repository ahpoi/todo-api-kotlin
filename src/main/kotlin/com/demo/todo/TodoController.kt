package com.demo.todo

import com.demo.todo.model.Todo
import com.demo.todo.model.TodoRequest
import com.demo.todo.model.TodoResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.notFound
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
open class TodoController(val service: TodoService) {

    @PostMapping
    fun createTodo(@RequestBody request: TodoRequest): ResponseEntity<TodoResponse> {
        val todo = service.saveTodo(Todo.fromRequestToEntity(request))
        return status(HttpStatus.OK).body(Todo.fromEntityToResponse(todo))
    }

    @GetMapping("/{uuid}")
    fun getTodo(@PathVariable("uuid") id: String): ResponseEntity<TodoResponse> {
        return service.findTodo(id)?.let { todo -> status(HttpStatus.OK).body(Todo.fromEntityToResponse(todo)) } ?: notFound().build()
    }

}


