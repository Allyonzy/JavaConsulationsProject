
package ru.innopolis.java;

public class LoginException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LoginException(String cause) {
        super(cause);
    }
}
