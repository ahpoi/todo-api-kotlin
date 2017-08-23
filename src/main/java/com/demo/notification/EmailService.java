package com.demo.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {

    private final String smtpServer;

    private final String smtpUserName;

    private final String smtpPassword;

    public EmailService(@Value("${smtp.server}") String smtpServer,
                        @Value("${smtp.username}") String smtpUserName,
                        @Value("${smtp.password}") String smtpPassword) {
        this.smtpServer = smtpServer;
        this.smtpUserName = smtpUserName;
        this.smtpPassword = smtpPassword;
    }

    @Override
    public void sendMessage(String recipient, String content) {
        //Create EmailService using JavaMail..etc
        System.out.println(String.format("Sending email from: %s with username %s and password %s", smtpServer, smtpUserName, smtpPassword));
        System.out.println("Recipient " + recipient);
        System.out.println("Content " + content);
    }

}
