package br.com.alura;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TesteMultiplasThreads {
    public static void main(String[] args) {
        //ExecutorService executor = Executors.newFixedThreadPool(50000); // Cria um pool de threads com 5 threads fixas.
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor(); // Cria um executor que utiliza threads virtuais para cada tarefa.
        
        Instant inicio = Instant.now(); // Captura o instante atual antes de iniciar a execução das tarefas.

        try (ExecutorService e = executor) {
            // Fazendo um loop para criar e executar 10.000 tarefas.
            for (int i = 0; i < 50000; i++) {
                var tarefa = new ExecutaTarefa(); // Cria uma nova tarefa utilizando a classe ExecutaTarefa.
                e.execute(tarefa); // Envia a tarefa para execução no pool de threads.
            }
        }

        Instant fim = Instant.now(); // Captura o instante atual após a execução das tarefas.

        Duration duracao = Duration.between(inicio, fim); // Calcula a duração total da execução das tarefas.

        System.out.println("Duração: " + duracao.toMillis() + " milissegundos"); // Imprime a duração total em milissegundos.
    }
}
