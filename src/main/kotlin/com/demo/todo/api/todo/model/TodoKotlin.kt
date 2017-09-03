package com.demo.todo.api.todo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class TodoKotlin(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
                      val name: String,
                      val description: String,
                      val createdAt: Long) {

    companion object {
        fun fromDtoRequest(request: TodoKotlinDtoRequest) = TodoKotlin(
                name = request.name,
                description = request.description,
                createdAt = System.currentTimeMillis())
    }

    fun toDtoResponse() = TodoKotlinDtoResponse(
            id = this.id,
            name = this.name,
            description = this.description)

}