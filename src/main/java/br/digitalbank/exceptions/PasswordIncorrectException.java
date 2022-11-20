package br.digitalbank.exceptions;

public class PasswordIncorrectException extends RuntimeException {

    public PasswordIncorrectException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Credential is incorret.";
    }
}
