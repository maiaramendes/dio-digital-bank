package br.digitalbank.service;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final UserService userService;

    public void hello() {
        Scanner scanner = new Scanner(System.in);
        Account account;

        System.out.println("=======================================");
        System.out.println("Olá, o que você deseja fazer hoje?");

        System.out.println("1- Create an account. 2- Login");
        int value = Integer.parseInt(scanner.next());

        ServiceType serviceType = ServiceType.toServiceType(value);

        if (ServiceType.CREATE_ACCOUNT == serviceType) {
            System.out.println("=======================================");
            System.out.println("Vamos criar a sua conta...");

            System.out.println("Digite o seu nome completo");
            final String name = scanner.next();

            System.out.println("Digite o seu cpf");
            final String cpf = scanner.next();

            System.out.println("Digite a sua senha");
            final String password = scanner.next();

            System.out.println("Aguarde um momento, estamos criando a sua conta...");
            account = userService.create(name, cpf, password);

            System.out.println(String.format("Conta criada com sucesso! O número da sua conta é {}. Você deseja " +
                    "acessar a sua conta? 1- Sim. 2- Não", account.getNumber()));
            int action = scanner.nextInt();

            if (action == 1) {
                account = userService.login(cpf, password);
            } else {
                scanner.close();
            }
        } else {
            System.out.println("=======================================");
            System.out.println("Digite o seu cpf:");
            final String cpf = scanner.next();

            System.out.println("Digite a sua senha:");
            final String password = scanner.next();

            account = userService.login(cpf, password);
        }

        System.out.println("=======================================");
        System.out.println(String.format("Olá {}, o que você deseja fazer hoje?", account.getUser().getName()));

        ServiceType.getAllForBank();
        value = scanner.nextInt();

        serviceType = ServiceType.toServiceType(value);
        if (ServiceType.LOGOUT == serviceType) {
            scanner.close();
        } else if (ServiceType.BANK_STATEMENT == serviceType) {

        } else {

        }
    }
}
