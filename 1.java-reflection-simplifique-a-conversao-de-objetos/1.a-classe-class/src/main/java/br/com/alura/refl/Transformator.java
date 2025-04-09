package br.com.alura.refl;

public class Transformator {
    // Criado um método genérico chamado transform que retorna dois parâmetros, um do tipo I de input e outro do tipo O de output, recebendo como parâmetro um input.
    public <I, O> transform(I input) throws ClassNotFoundException {
        Class<?> classe = input.getClass(); // Criado uma variável do tipo Class que não foi especificado o tipo, chamada classe que recebe o tipo da classe do input.
        Class<?> target = classe.forName(classe.getClass() + "DTO"); // Criado uma variável do tipo Class que não foi especificado o tipo, chamada target que recebe o tipo da classe do input concatenado com a string DTO.
    }
}
