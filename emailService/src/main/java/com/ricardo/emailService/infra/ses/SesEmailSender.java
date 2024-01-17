package com.ricardo.emailService.infra.ses;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.ricardo.emailService.adapters.EmailSenderGateway;
import com.ricardo.emailService.core.exception.EmailServiceException;
import org.springframework.stereotype.Service;


@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService emailService;


    public SesEmailSender(AmazonSimpleEmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("emailCadastradoNaAws.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );

        try {
            this.emailService.sendEmail(request);
        } catch (AmazonClientException exception) {
            throw new EmailServiceException("Failure while send email", exception);
        }
    }
}
