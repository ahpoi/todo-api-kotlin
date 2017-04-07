package com.demo.todo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TodoRequest(@JsonProperty("name") val name: String,
                       @JsonProperty("description") val description: String)