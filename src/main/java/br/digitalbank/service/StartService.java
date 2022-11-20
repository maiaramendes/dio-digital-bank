package br.digitalbank.service;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.handlers.start.StartHandler;
import br.digitalbank.handlers.service.ServiceHandler;
import br.digitalbank.model.Account;
import br.digitalbank.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class StartService {

    private final List<StartHandler> startHandlerList;

    private final MenuService menuService;

    public void start() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("Olá, o que você deseja fazer hoje?");

        ServiceType.getAllForLogin();
        System.out.println();
        int value = Integer.parseInt(scanner.next());

        final ServiceType serviceType = ServiceType.toServiceType(value);

        final Account account = startHandlerList.stream()
                .filter(t -> t.type().equals(serviceType))
                .findFirst()
                .get()
                .action();

        menuService.serviceMenu(account);

        System.out.println("=================================");
        System.out.println("Obrigada por usar o nosso banco! Nos vemos na próxima.");
    }
}
