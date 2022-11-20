package br.digitalbank.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ServiceType {
    BANK_STATEMENT("Bank statement", 1),
    CREATE_ACCOUNT("Create an account", 1),
    LOGIN("Login", 2),
    LOGOUT("Logout", 4),
    OTHERS("Others", 5);

    public final String label;

    public final int index;

    public static List<String> getAllForLogin() {
        return List.of(CREATE_ACCOUNT, LOGIN)
                .stream()
                .map(ServiceType::getServiceFormatted)
                .toList();
    }

    public static List<String> getAllForBank() {
        return List.of(BANK_STATEMENT, OTHERS, LOGOUT)
                .stream()
                .map(ServiceType::getServiceFormatted)
                .toList();
    }

    public static ServiceType toServiceType(final int index) {
        return Arrays.stream(ServiceType.values()).filter(t -> t.index == index).findFirst().orElse(LOGIN);
    }

    public String getServiceFormatted() {
        final String formatted = String.format("{} - {}.", index, label);
        System.out.print(formatted);
        return formatted;
    }
}
