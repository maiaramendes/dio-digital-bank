package br.digitalbank.exceptions;

public class AccountNotFoundException extends RuntimeException {

    private Long number;

    public AccountNotFoundException() {
        super();
    }

    public AccountNotFoundException(final long number) {
        super();
        this.number = number;
    }

    @Override
    public String getMessage() {
        if (number != null) {
            return String.format("Account {} not found. Try again later!", number);
        }
        return "Account not found. Try again later!";
    }
}
