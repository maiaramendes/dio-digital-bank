package br.digitalbank.handlers.service;

import br.digitalbank.enums.ServiceType;
import br.digitalbank.model.Account;

public interface ServiceHandler {

    Account action(final Account account);

    ServiceType type();
}
