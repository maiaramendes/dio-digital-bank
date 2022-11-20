package br.digitalbank;

import br.digitalbank.service.StartService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final StartService startService;

    @Override
    public void run(String...args) {
        startService.start();
    }
}
