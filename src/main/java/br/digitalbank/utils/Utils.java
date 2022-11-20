package br.digitalbank.utils;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static ServiceType serviceMenu(final Account account) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n============= MENU =============");

        System.out.println(String.format("Olá %s, o que você deseja fazer?", account.getUser().getName()));
        ServiceType.getAllForBank();
        System.out.println("");

        return ServiceType.toServiceType(scanner.nextInt());
    }

    public static String getEnumOptionFormatted(final int index, final String label) {
        final String formatted = String.format("%s - %s | ", index, label);
        System.out.println(formatted);
        return formatted;
    }

    public static String formatDate(final LocalDateTime date) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return formatter.format(date);
    }

    public static int generateAccountNumber() {
        final Random random = new Random();
        return random.nextInt(1000) + 10;
    }
}
