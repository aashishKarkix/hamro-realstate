package com.realstate.core.exception;

/**
 * Custom exception class for errors that occur during email sending.
 * Author: [Aashish Karki]
 */
public class EmailSendingException extends RuntimeException {

    /**
     * Constructs a new EmailSendingException with the specified detail message.
     *
     * @param message The detail message describing the error.
     */
    public EmailSendingException(String message) {
        super(message);
    }

    /**
     * Constructs a new EmailSendingException with the specified detail message and cause.
     *
     * @param message The detail message describing the error.
     * @param cause   The cause of the exception.
     */
    public EmailSendingException(String message, Throwable cause) {
        super(message, cause);
    }
}
