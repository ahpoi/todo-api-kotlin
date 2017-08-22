package com.demo.todo.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class TodoDtoRequest
@JsonCreator constructor(@JsonProperty("name") val name: String,
                         @JsonProperty("description") val description: String)

data class TodoDtoResponse(val id: String,
                           val name: String,
                           val description: String)