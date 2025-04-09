package br.com.alura;

public class PessoaDTO {
    private String nome; // Criado um atributo nome do tipo String responsável por armazenar o nome da pessoa.
    private String cpf; // Criado um atributo cpf do tipo String responsável por armazenar o cpf da pessoa.

    // Criado um getter chamado getNome que retorna o nome da pessoa.
    public String getNome() {
        return nome; // Retorna o nome da pessoa.
    }

    // Criado um getter chamado getCpf que retorna o cpf da pessoa.
    public String getCpf() {
        return cpf; // Retorna o cpf da pessoa.
    }
}
