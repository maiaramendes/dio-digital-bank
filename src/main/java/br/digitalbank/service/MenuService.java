package br.digitalbank.service;


import br.digitalbank.enums.ServiceType;
import br.digitalbank.handlers.service.ServiceHandler;
import br.digitalbank.model.Account;
import br.digitalbank.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final List<ServiceHandler> serviceHandlerList;

    public void serviceMenu(final Account account) {
        ServiceType menu;
        do {
            menu = Utils.serviceMenu(account);
            final ServiceType finalMenu = menu;
            serviceHandlerList.stream()
                    .filter(t -> t.type().equals(finalMenu))
                    .findFirst()
                    .ifPresent(t -> t.action(account));
        } while (!ServiceType.LOGOUT.equals(menu));
    }
}
