package com.demo.todo.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class TodoKotlinDtoRequest
@JsonCreator constructor(@JsonProperty("name") val name: String,
                         @JsonProperty("description") val description: String)

data class TodoKotlinDtoResponse(val id: Long,
                                 val name: String,
                                 val description: String)