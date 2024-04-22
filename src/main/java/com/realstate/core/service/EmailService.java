package com.realstate.core.service;

import com.realstate.core.exception.EmailSendingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.ST;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Service class for sending email notifications.
 * Author: [Aashish Karki]
 */
@Service
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;
    @Value("${mail.username}")
    private String fromEmail;

    /**
     * Constructor to initialize the EmailService with a JavaMailSender instance.
     *
     * @param javaMailSender The JavaMailSender instance used to send emails.
     */
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Sends a verification email to the specified recipient.
     *
     * @param toEmail          The recipient's email address.
     * @param verificationLink The verification link to be included in the email.
     * @param firstName        The first name of the recipient.
     * @param lastName         The last name of the recipient.
     */
    public void sendVerificationEmail(String toEmail, String verificationLink, String firstName, String lastName) {
        try {
            String templateContent = loadTemplateFromFile("template/email/email-template.st");

            ST stringTemplate = new ST(templateContent, '<', '>');
            stringTemplate.add("firstName", firstName);
            stringTemplate.add("lastName", lastName);
            stringTemplate.add("verificationLink", verificationLink);

            String renderedContent = stringTemplate.render();

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(fromEmail);
            mailMessage.setTo(toEmail);
            mailMessage.setSubject("Account Verification");
            mailMessage.setText(renderedContent);

            log.debug("mail message : {}", mailMessage);
            javaMailSender.send(mailMessage);
        } catch (MailException e) {
            throw new EmailSendingException("Error while sending: {}", e);
        }
    }

    /**
     * Loads the content of an email template from a file.
     *
     * @param path The path to the email template file.
     * @return The content of the email template as a String.
     * @throws RuntimeException If an error occurs while loading the template file.
     */
    private String loadTemplateFromFile(String path) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) {
                log.error("template file not found : {}", path);
                throw new IOException("Template file not found: " + path);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.info("Error loading template : {}", path, e);
            throw new RuntimeException("Error loading template file: " + path, e);
        }
    }
}