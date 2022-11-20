package br.digitalbank.handlers.start;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuitHandler implements StartHandler {

    @Override
    public Account action() {
        System.exit(0);
        return null;
    }

    @Override
    public ServiceType type() {
        return ServiceType.LOGOUT;
    }
}
