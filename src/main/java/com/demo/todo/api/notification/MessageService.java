package com.demo.todo.api.notification;

public interface MessageService {

    void sendMessage(String recipient, String content);

}
