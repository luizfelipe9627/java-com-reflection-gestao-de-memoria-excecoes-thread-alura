package br.com.alura;

import java.math.BigDecimal;

// A classe OperacaoSaque implementa a interface Runnable, que é usada para criar uma thread que é responsável por executar a operação de saque em uma conta.
public class OperacaoSaque implements Runnable {

    private Conta conta;
    private BigDecimal valor;

    public OperacaoSaque(Conta conta, BigDecimal valor) {
        this.conta = conta;
        this.valor = valor;
    }

    public void executa() {
        System.out.println("Iniciando operação de saque.");
        var saldoAtual = conta.getSaldo();

        if (saldoAtual.compareTo(valor) >= 0) {
            System.out.println("Debitando valor da conta");
            conta.debitaSaldo(valor);
            System.out.println("Saldo atual: " +conta.getSaldo());
        }
        System.out.println("Finalizando operação de saque.");
    }

    // A anotação @Override indica que o método run() sobrescreve o método run() da interface Runnable.
    @Override
    // O método run() é chamado quando a thread é iniciada.
    public void run() {
        executa(); // O método executa() é chamado para executar a operação de saque.
        System.out.println(Thread.currentThread().getName()); // Imprime o nome da thread atual.
    }
}
