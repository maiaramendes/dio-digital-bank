package br.digitalbank.handlers.start;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;
import br.digitalbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class CreateAccountHandler implements StartHandler {

    private final UserService userService;

    @Override
    public Account action() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("Vamos criar a sua conta...");

        System.out.println("Digite o seu nome completo");
        final String name = scanner.next();

        System.out.println("Digite o seu cpf");
        final String cpf = scanner.next();

        System.out.println("Digite a sua senha");
        final String password = scanner.next();

        System.out.println("Aguarde um momento, estamos criando a sua conta...");
        return userService.create(name, cpf, password);
    }

    @Override
    public ServiceType type() {
        return ServiceType.CREATE_ACCOUNT;
    }
}
