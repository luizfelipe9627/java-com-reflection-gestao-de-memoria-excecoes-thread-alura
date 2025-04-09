package br.com.alura.adopetstore.service;

import br.com.alura.adopetstore.dto.ProdutoDTO;
import br.com.alura.adopetstore.dto.RelatorioEstoque;
import br.com.alura.adopetstore.dto.RelatorioFaturamento;
import br.com.alura.adopetstore.repository.EstoqueRepository;
import br.com.alura.adopetstore.repository.PedidoRepository;
import br.com.alura.adopetstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class RelatorioService {
    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    // A anotação @Async indica que o método deve ser executado de forma assíncrona, ou seja, em uma thread separada do thread principal, recebendo o nome do executor configurado no AsyncConfig.
    @Async
    // O CompletableFuture é uma classe que representa um resultado futuro de uma operação assíncrona. Ele permite que você trabalhe com resultados que ainda não estão disponíveis, mas que estarão em algum momento no futuro.
    public CompletableFuture<RelatorioEstoque> infoEstoque(){
        var produtosSemEstoque = estoqueRepository.produtosComEstoqueZerado()
                .stream().map(ProdutoDTO::new)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(new RelatorioEstoque(produtosSemEstoque)); // Retorna um CompletableFuture com o relatório de estoque zerado.
    }

    // A anotação @Async indica que o método deve ser executado de forma assíncrona, ou seja, em uma thread separada do thread principal, recebendo o nome do executor configurado no AsyncConfig.
    @Async
    // O CompletableFuture é uma classe que representa um resultado futuro de uma operação assíncrona. Ele permite que você trabalhe com resultados que ainda não estão disponíveis, mas que estarão em algum momento no futuro.
    public CompletableFuture<RelatorioFaturamento> faturamentoObtido() {
        var dataOntem = LocalDate.now().minusDays(1);
        var faturamentoTotal = pedidoRepository.faturamentoTotalDoDia(dataOntem);

        var estatisticas = pedidoRepository.faturamentoTotalDoDiaPorCategoria(dataOntem);

        return CompletableFuture.completedFuture(new RelatorioFaturamento(faturamentoTotal, estatisticas)); // Retorna um CompletableFuture com o relatório de faturamento obtido.
    }
}