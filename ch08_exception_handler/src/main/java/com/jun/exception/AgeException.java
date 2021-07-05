package com.jun.exception;

/**
 * @author Wu
 */
public class AgeException extends MyUserException {

    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeException(String message) {
        super(message);
    }

    public AgeException(Throwable cause) {
        super(cause);
    }

    public AgeException() {
        super();
    }
}
