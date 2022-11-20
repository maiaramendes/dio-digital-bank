package br.digitalbank.handlers.start;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;

public interface StartHandler {

    Account action();

    ServiceType type();
}
