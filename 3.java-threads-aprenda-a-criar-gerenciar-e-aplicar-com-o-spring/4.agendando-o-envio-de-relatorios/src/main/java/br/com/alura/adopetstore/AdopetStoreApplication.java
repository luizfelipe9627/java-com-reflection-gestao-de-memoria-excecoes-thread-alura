package br.com.alura.adopetstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// A annotação @EnableAsync ativa o suporte a métodos assíncronos.
@EnableAsync
// A annotação @EnableScheduling ativa o suporte a tarefas agendadas.
@EnableScheduling
public class AdopetStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopetStoreApplication.class, args);
	}

}
