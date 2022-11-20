package br.digitalbank;

import br.digitalbank.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final HelloService helloService;

    @Override
    public void run(String...args) {
        helloService.hello();
    }
}
