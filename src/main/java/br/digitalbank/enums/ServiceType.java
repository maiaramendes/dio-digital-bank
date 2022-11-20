package br.digitalbank.enums;

import br.digitalbank.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ServiceType {
    BANK_STATEMENT("Histórico de transações", 4),
    BALANCE("Saldo", 5),
    CREATE_ACCOUNT("Criar uma conta", 1),
    LOGIN("Entrar", 2),
    LOGOUT("Sair", 3),
    OTHERS("Outros", 6);

    public final String label;

    public final int index;

    public static List<String> getAllForLogin() {
        return List.of(CREATE_ACCOUNT, LOGIN, LOGOUT)
                .stream()
                .map(t -> Utils.getEnumOptionFormatted(t.index, t.label))
                .toList();
    }

    public static List<String> getAllForBank() {
        return List.of(BANK_STATEMENT, BALANCE, OTHERS, LOGOUT)
                .stream()
                .sorted(Comparator.comparing(ServiceType::getIndex))
                .map(t -> Utils.getEnumOptionFormatted(t.index, t.label))
                .toList();
    }

    public static ServiceType toServiceType(final int index) {
        return Arrays.stream(ServiceType.values())
                .filter(t -> t.index == index)
                .findFirst()
                .orElse(LOGIN);
    }

}
