package com.demo.todojava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoJava {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long createdAt;

    //Required by Jpa/hibernate
    public TodoJava() {
    }

    private TodoJava(String name, String description, Long createdAt) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public TodoJavaDtoResponse toDtoResponse() {
        return new TodoJavaDtoResponse(this.id, this.name, this.description);
    }

    public static TodoJava fromDtoRequest(TodoJavaDtoRequest request) {
        return new Builder()
                .withCreatedAt(System.currentTimeMillis())
                .withName(request.getName())
                .withDescription(request.getDescription()).build();
    }

    public static final class Builder {

        private String name;

        private String description;

        private Long createdAt;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withCreatedAt(Long createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TodoJava build() {
            return new TodoJava(name, description, createdAt);
        }
    }
}
