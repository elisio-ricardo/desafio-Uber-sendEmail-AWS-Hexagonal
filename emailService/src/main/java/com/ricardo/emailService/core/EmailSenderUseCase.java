package com.ricardo.emailService.core;

public interface EmailSenderUseCase {

    void sendEmail(String to, String subject, String body);
}
