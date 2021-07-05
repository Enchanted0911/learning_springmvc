package com.jun.exception;

/**
 * @author Wu
 */
public class MyUserException extends Exception {
    public MyUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyUserException(String message) {
        super(message);
    }

    public MyUserException(Throwable cause) {
        super(cause);
    }

    public MyUserException() {
        super();
    }
}
