package com.jun.exception;

/**
 * @author Wu
 */
public class NameException extends MyUserException {
    public NameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }

    public NameException(Throwable cause) {
        super(cause);
    }
}
