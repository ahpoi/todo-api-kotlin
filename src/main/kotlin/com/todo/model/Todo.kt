package com.todo.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Todo(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
                val uuid: String,
                val name: String,
                val description: String,
                val createdAt: Long) {

    companion object {
        fun fromRequestToEntity(request: TodoRequest) = Todo(
                uuid = UUID.randomUUID().toString(),
                name = request.name,
                description = request.description,
                createdAt = System.currentTimeMillis())

        fun fromEntityToResponse(todo: Todo) = TodoResponse(
                id = todo.uuid,
                name = todo.name,
                description = todo.description)
    }

}