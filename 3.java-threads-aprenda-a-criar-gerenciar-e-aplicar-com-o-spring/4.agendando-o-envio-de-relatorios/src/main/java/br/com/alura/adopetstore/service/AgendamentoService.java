package br.com.alura.adopetstore.service;

import br.com.alura.adopetstore.email.EmailRelatorioGerado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AgendamentoService {
    @Autowired
    private RelatorioService relatorioService;

    @Autowired
    private EmailRelatorioGerado emailRelatorioGerado;

    // Annotação @Scheduled indica que o método deve ser executado em um intervalo fixo de tempo.
    @Scheduled(cron = "0 55 23 * * *") // Executa todos os dias ao meio-dia.
    // Método que envia o relatório de vendas por e-mail.
    public void envioEmailsAgendado() throws ExecutionException, InterruptedException {
        var estoqueZerado = relatorioService.infoEstoque(); // Armazena o relatório de estoque zerado.
        var faturamenteObtido = relatorioService.faturamentoObtido(); // Armazena o relatório de faturamento obtido.

        CompletableFuture.allOf(estoqueZerado, faturamenteObtido).join(); // Aguarda a conclusão de todas as tarefas assíncronas antes de prosseguir.

        emailRelatorioGerado.enviar(estoqueZerado.get(), faturamenteObtido.get()); // Envia o e-mail com os relatórios gerados.
        System.out.println("Thread do agendamento: " + Thread.currentThread().getName()); // Imprime o nome da thread que executou o agendamento.
    }
}
