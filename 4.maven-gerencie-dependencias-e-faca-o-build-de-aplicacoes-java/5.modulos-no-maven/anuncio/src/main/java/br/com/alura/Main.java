package br.com.alura;

import br.com.alura.model.Anuncio;
import br.com.alura.model.Produto;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        var produto = new Produto(1, "TV", "4K", new BigDecimal(2000), "Eletrodoméstico");
        var anuncio = new Anuncio(produto, new BigDecimal(4000), 20);

        System.out.println(anuncio.toString());
    }
}