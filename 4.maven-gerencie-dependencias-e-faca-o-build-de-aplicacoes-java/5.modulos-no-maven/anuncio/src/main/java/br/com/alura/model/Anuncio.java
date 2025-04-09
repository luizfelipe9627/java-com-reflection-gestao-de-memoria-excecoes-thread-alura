package br.com.alura.model;

import java.math.BigDecimal;

public class Anuncio {
    private Produto produto; // Está importando a classe Produto de outro pacote/módulo.
    private BigDecimal preco;
    private Integer quantidade;

    public Anuncio(Produto produto, BigDecimal preco, Integer quantidade) {
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Criado um método toString que retorna uma representação em String do objeto Produto.
    @Override
    public String toString() {
        // Retorna uma representação em String do objeto Produto.
        return "Anuncio{" +
                "produto=" + produto +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
