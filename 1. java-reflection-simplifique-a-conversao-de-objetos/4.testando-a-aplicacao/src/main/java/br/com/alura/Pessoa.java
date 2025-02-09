package br.com.alura;

public class Pessoa {

    // Criado um construtor para a classe Pessoa, que recebe um id, nome e cpf.
    public Pessoa(Integer id, String nome, String cpf) {
        this.id = id; // Atribui o id recebido ao atributo id da classe.
        this.nome = nome; // Atribui o nome recebido ao atributo nome da classe.
        this.cpf = cpf; // Atribui o cpf recebido ao atributo cpf da classe.
    }

    // Criado um construtor para a classe Pessoa, que recebe um nome.
    public Pessoa(String nome) {
        this.nome = nome; // Atribui o nome recebido ao atributo nome da classe.
    }

    private Integer id;
    private String nome;
    private String cpf;

    // Método getter chamado getNome, que retorna o nome da pessoa.
    public String getNome() {
        return nome; // Retorna o nome da pessoa.
    }

    // Método getter chamado getCpf, que retorna o cpf da pessoa.
    public String getCpf() {
        return cpf; // Retorna o cpf da pessoa.
    }
}
