package com.demo.todo

import com.demo.todo.model.Todo
import com.demo.todo.model.TodoDtoRequest
import com.demo.todo.model.TodoDtoResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.notFound
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
open class TodoController(val service: TodoService) {

    @PostMapping
    fun createTodo(@RequestBody request: TodoDtoRequest): ResponseEntity<TodoDtoResponse> {
        val todo = service.saveTodo(Todo.fromRequestDto(request))
        return status(HttpStatus.OK).body(todo.toResponseDto())
    }

    @GetMapping("/{id}")
    fun getTodo(@PathVariable("id") id: String): ResponseEntity<TodoDtoResponse> {
        return service.findTodo(id)?.let { todo -> status(HttpStatus.OK).body(todo.toResponseDto()) } ?: notFound().build()
    }

}


