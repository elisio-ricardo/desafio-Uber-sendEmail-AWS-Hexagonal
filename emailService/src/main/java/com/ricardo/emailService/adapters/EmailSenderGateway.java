package com.ricardo.emailService.adapters;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);
}
