package br.com.fiap;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Fast-Service",
        description = "Sistema de Auto-atendimento"))
public class FastServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastServiceApplication.class, args);
    }

}
