package br.digitalbank.enums;

import br.digitalbank.model.Account;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TransactionType {
    DEPOSIT {
        @Override
        public void operation(final Account account, final Double amount) {
            account.setBalance(account.getBalance() + amount);
        }
    },
    TRANSFER {
        @Override
        public void operation(final Account account, final Double amount) {
            account.setBalance(account.getBalance() - amount);
        }
    },
    WITHDRAW {
        @Override
        public void operation(final Account account, final Double amount) {
            account.setBalance(account.getBalance() - amount);
        }
    };

    public abstract void operation(final Account account, final Double amount);
}
