package br.digitalbank.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException() {
        super();
    }

    @Override
    public String getMessage() {
        return "User already exists";
    }
}
