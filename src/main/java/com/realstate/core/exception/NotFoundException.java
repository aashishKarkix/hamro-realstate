package com.realstate.core.exception;

/**
 * Exception class representing a resource not found error.
 * This exception is thrown when a requested resource is not found.
 * It extends the RuntimeException class, allowing it to be unchecked.
 * Author: [Aashish Karki]
 */
public class NotFoundException extends RuntimeException {

    /**
     * Constructs a new NotFoundException with the specified error message.
     *
     * @param message The error message describing the resource not found error.
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new NotFoundException with the specified error message and cause.
     *
     * @param message The error message describing the resource not found error.
     * @param clause  The cause of the resource not found error.
     */
    public NotFoundException(String message, Throwable clause) {
        super(message, clause);
    }
}
