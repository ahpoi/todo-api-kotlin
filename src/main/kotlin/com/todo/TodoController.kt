package com.todo

import com.todo.model.Todo
import com.todo.model.TodoRequest
import com.todo.model.TodoResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
open class TodoController(val service: TodoService) {

    @PostMapping
    fun createTodo(@RequestBody request: TodoRequest): ResponseEntity<TodoResponse> {
        val todo = service.saveTodo(Todo.fromRequestToEntity(request))
        return ResponseEntity.status(HttpStatus.OK).body(Todo.fromEntityToResponse(todo))
    }

    @GetMapping("/{uuid}")
    fun getTodo(@PathVariable("uuid") id: String): ResponseEntity<TodoResponse> {
        val todo = service.findTodo(id)?.let { it } ?: return ResponseEntity.notFound().build()
        return ResponseEntity.status(HttpStatus.OK).body(Todo.fromEntityToResponse(todo))
    }
}


