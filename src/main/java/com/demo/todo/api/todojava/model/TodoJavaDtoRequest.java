package com.demo.todo.api.todojava.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoJavaDtoRequest {

    private final String name;

    private final String description;

    @JsonCreator
    public TodoJavaDtoRequest(@JsonProperty("name") String name,
                              @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
