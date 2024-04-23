package com.realstate.core.exception;

/**
 * Custom exception class for representing token expiration errors.
 * Author: [Aashish Karki]
 */
public class TokenExpireException extends Exception {

  /**
   * Constructs a new TokenExpireException with the specified detail message.
   *
   * @param message The detail message describing the token expiration error.
   */
  public TokenExpireException(String message) {
    super(message);
  }

  /**
   * Constructs a new TokenExpireException with the specified detail message and cause.
   *
   * @param message The detail message describing the token expiration error.
   * @param cause The cause of the exception.
   */
  public TokenExpireException(String message, Throwable cause) {
    super(message, cause);
  }
}
