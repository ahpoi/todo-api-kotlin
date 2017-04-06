package com.todo

import com.todo.model.Todo
import com.todo.model.TodoRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
open class TodoController(val service: TodoService) {

    @PostMapping
    fun createTodo(@RequestBody request: TodoRequest): ResponseEntity<Todo> {
        val todo = service.saveTodo(Todo.fromRequestToEntity(request))
        return ResponseEntity.status(HttpStatus.OK).body(todo)
    }

    @GetMapping("/{uuid}")
    fun getTodo(@PathVariable("uuid") id: String): ResponseEntity<Todo> {
        val todo = service.findTodo(id)
        return if (todo != null) ResponseEntity.status(HttpStatus.OK).body(todo) else ResponseEntity.notFound().build()
    }

}
