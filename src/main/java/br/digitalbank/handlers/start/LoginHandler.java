package br.digitalbank.handlers.start;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;
import br.digitalbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class LoginHandler implements StartHandler {

    private final UserService userService;

    @Override
    public Account action() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("Digite o seu cpf:");
        final String cpf = scanner.next();

        System.out.println("Digite a sua senha:");
        final String password = scanner.next();

        return userService.login(cpf, password);
    }

    @Override
    public ServiceType type() {
        return ServiceType.LOGIN;
    }
}
