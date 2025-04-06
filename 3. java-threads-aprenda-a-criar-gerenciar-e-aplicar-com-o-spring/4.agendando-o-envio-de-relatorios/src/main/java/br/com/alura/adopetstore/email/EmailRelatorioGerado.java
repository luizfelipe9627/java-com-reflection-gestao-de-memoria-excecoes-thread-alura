package br.com.alura.adopetstore.email;

import br.com.alura.adopetstore.dto.RelatorioEstoque;
import br.com.alura.adopetstore.dto.RelatorioFaturamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailRelatorioGerado {
    @Autowired
    private EnviadorEmail enviador;

    // A anotação @Async indica que o método deve ser executado de forma assíncrona, ou seja, em uma thread separada do thread principal, recebendo o nome do executor configurado no AsyncConfig.
    @Async("asyncExecutor")
    public void enviar(RelatorioEstoque estoque, RelatorioFaturamento faturamento) {
        enviador.enviarEmail(
    "Relatórios gerados",
"admin@email.com",
            """
                Olá!
                
                Seus relátorios foram gerados e seguem abaixo:
                
                %s
                
                %s"
            """.formatted(estoque, faturamento)

        );
        System.out.println("Thread do email: " + Thread.currentThread().getName());
    }
}
