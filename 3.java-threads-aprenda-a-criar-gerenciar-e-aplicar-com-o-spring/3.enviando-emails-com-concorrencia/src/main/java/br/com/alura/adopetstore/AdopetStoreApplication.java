package br.com.alura.adopetstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// A annotação @EnableAsync ativa o suporte a métodos assíncronos.
@EnableAsync
public class AdopetStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopetStoreApplication.class, args);
	}

}
