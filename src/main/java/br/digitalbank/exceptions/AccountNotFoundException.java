package br.digitalbank.exceptions;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta não encontrada!";
    }
}
