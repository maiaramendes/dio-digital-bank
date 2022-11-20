package br.digitalbank.handlers.service;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class LogoutHandler implements ServiceHandler {

    @Override
    public Account action(Account account) {
        System.exit(0);
        return null;
    }

    @Override
    public ServiceType type() {
        return ServiceType.LOGOUT;
    }
}
