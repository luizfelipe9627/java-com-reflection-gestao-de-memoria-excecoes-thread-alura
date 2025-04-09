package br.com.alura;

import br.com.alura.model.Produto;
import br.com.alura.service.TraduzProdutoService;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Criado uma lista de produtos que recebe o retorno do CsvToBeanBuilder que converte o arquivo CSV em uma lista de objetos Produto.
        List<Produto> produtos = new CsvToBeanBuilder(new FileReader("src/main/resources/products.csv"))
                .withType(Produto.class).build().parse();

        // Criado um loop que percorre a lista de produtos.
        for (Produto produto : produtos) {
            System.out.println(produto); // Imprime o produto.
        }

        TraduzProdutoService traduzProdutoService = new TraduzProdutoService(); // Criado um objeto da classe TraduzProdutoService.

        // Criado um loop que percorre a lista de produtos e traduz o nome, descrição e categoria de cada produto.
        for (Produto produto : produtos) {
            traduzProdutoService.traduzir(produto); // Chama o método traduzir da classe TraduzProdutoService passando o produto como parâmetro.
            System.out.println(produto); // Imprime o produto traduzido.
        }
    }
}