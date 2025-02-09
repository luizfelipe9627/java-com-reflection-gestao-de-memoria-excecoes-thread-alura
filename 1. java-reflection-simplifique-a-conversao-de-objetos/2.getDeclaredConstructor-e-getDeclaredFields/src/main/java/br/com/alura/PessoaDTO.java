package br.com.alura;

public class PessoaDTO {

    private String nome; // Criado um atributo nome do tipo String responsável por armazenar o nome da pessoa.
    private String cpf; // Criado um atributo cpf do tipo String responsável por armazenar o cpf da pessoa.

    // Criado um construtor que recebe como parâmetro o nome e o cpf.
    public PessoaDTO(String nome, String cpf) {
        this.nome = nome; // Atribuindo o valor do parâmetro nome ao atributo nome.
        this.cpf = cpf; // Atribuindo o valor do parâmetro cpf ao atributo cpf.
    }
}
