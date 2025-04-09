package br.com.alura.service;

import br.com.alura.model.Produto;
import space.dynomake.libretranslate.Language;
import space.dynomake.libretranslate.Translator;

public class TraduzProdutoService {

    // Criado um método chamado traduzir que recebe um objeto Produto como parâmetro.
    public void traduzir(Produto produto) {
        // Traduz o nome, descrição e categoria do produto de inglês para português e armazena em variáveis.
        String novoNome = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, produto.getName());
        String novaDescricao = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, produto.getDescription());
        String novaCategoria = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, produto.getCategory());

        produto.setName(novoNome); // Define o novo nome traduzido do produto.
        produto.setDescription(novaDescricao); // Define a nova descrição traduzida do produto.
        produto.setCategory(novaCategoria); // Define a nova categoria traduzida do produto.
    }
}
