package br.digitalbank.enums;

import br.digitalbank.model.Account;
import br.digitalbank.model.Transaction;
import br.digitalbank.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Getter
@AllArgsConstructor
public enum TransactionType {
    DEPOSIT("Depósito", 1) {
        @Override
        public void operation(final Account account, final Double amount) {
            account.setBalance(account.getBalance() + amount);
        }

        @Override
        public String message(final Transaction transaction, final Account account) {
            return String.format("[%s][%s] -> Você realizou um %s no valor de R$ %s",
                    label, transaction.createdAtFormatted(), label, transaction.getAmount());

        }
    },
    LOGOUT("Sair", 4) {
        @Override
        public void operation(final Account account, final Double amount) {
        }

        @Override
        public String message(final Transaction transaction, final Account account) {
            return null;
        }
    },
    TRANSFER("Transferência", 2) {
        @Override
        public void operation(final Account account, final Double amount) {
            account.setBalance(account.getBalance() - amount);
        }

        @Override
        public String message(final Transaction transaction, final Account account) {
            if (transaction.getSender().getId().equals(account.getId())) {
                return String.format("[%s][%s] -> Você realizou uma %s para %s no valor de R$ %s",
                        label, transaction.createdAtFormatted(), label, transaction.getRecipient().getNumber(),
                        transaction.getAmount());
            }

            return String.format("[%s][%s] -> Você recebeu uma %s de %s no valor de R$ %s",
                    label, transaction.createdAtFormatted(), label, transaction.getSender().getNumber(), transaction.getAmount());
        }
    },
    WITHDRAW("Saque", 3) {
        @Override
        public void operation(final Account account, final Double amount) {
            account.setBalance(account.getBalance() - amount);
        }

        @Override
        public String message(final Transaction transaction, final Account account) {
            return String.format("[%s][%s] -> Você realizou um %s da sua conta o valor de R$ %s",
                    label, transaction.createdAtFormatted(), label, transaction.getAmount());
        }
    };

    public final String label;

    public final int index;

    public abstract void operation(final Account account, final Double amount);

    public abstract String message(final Transaction transaction, final Account account);

    public static List<String> getMenu() {
        return Arrays.stream(TransactionType.values())
                .sorted(Comparator.comparing(t -> t.index))
                .map(t -> Utils.getEnumOptionFormatted(t.index, t.label))
                .toList();
    }

    public static TransactionType toTransactionType(final int index) {
        return Arrays.stream(TransactionType.values())
                .filter(t -> t.index == index)
                .findFirst()
                .orElse(null);
    }
}
