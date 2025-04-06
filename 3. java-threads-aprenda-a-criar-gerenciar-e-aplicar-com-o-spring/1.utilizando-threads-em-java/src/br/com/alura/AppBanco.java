package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {
    public static void main(String[] args) throws InterruptedException {
        var cliente = new Cliente("João"); // Cria um novo cliente com o nome "João".
        var conta = new Conta(cliente, new BigDecimal("150")); // Cria uma nova conta para o cliente "João" com saldo de 150 reais.

        var operacao = new OperacaoSaque(conta, new BigDecimal("150")); // Cria uma nova operação de saque de 150 reais na conta do cliente "Lucas".

        /*
            - A classe Thread é usada para criar e manipular threads em Java. Ela fornece métodos para iniciar, pausar, retomar e interromper threads.
            - Por exemplo, o método start() é usado para iniciar uma thread, enquanto o método sleep() é usado para pausar uma thread por um determinado período de tempo.
        */
        Thread saqueJoao = new Thread(operacao); // Cria uma nova thread para a operação de saque de João.
        Thread saqueMaria = new Thread(operacao); // Cria uma nova thread para a operação de saque de Maria.

        saqueJoao.start(); // Inicia a thread de saque de João.
        saqueMaria.start(); // Inicia a thread de saque de Maria.

        saqueJoao.join(); // Aguarda a conclusão da thread de saque de João.
        saqueMaria.join(); // Aguarda a conclusão da thread de saque de Maria.

        System.out.println(Thread.currentThread().getName()); // Imprime o nome da thread atual.
        System.out.println("Saldo final: " + conta.getSaldo()); // Imprime o saldo final da conta.

        // Saque João
        //operacao.executa(); // Executa a operação de saque.

        // Saque Maria
        //operacao.executa(); // Executa a operação de saque.
    }
}
