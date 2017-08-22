package com.demo.todo.model

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
        fun fromRequestDto(request: TodoDtoRequest) = Todo(
                uuid = UUID.randomUUID().toString(),
                name = request.name,
                description = request.description,
                createdAt = System.currentTimeMillis())
    }

    fun toResponseDto() = TodoDtoResponse(
            id = this.uuid,
            name = this.name,
            description = this.description)

}