package com.realstate.core.exception;

public class TokenExpireException extends Exception{
  public TokenExpireException(String message){
    super(message);
  }

  public TokenExpireException(String message, Throwable cause){
    super(message, cause);
  }
}
