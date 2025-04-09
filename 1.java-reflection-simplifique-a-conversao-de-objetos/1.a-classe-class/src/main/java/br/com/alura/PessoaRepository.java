package br.com.alura;

public class PessoaRepository {

    // Criado um método chamado list que retorna um novo objeto do tipo Pessoa.
    public Pessoa list() {
        return new Pessoa(1, "João", "1234"); // Retornando um novo objeto do tipo Pessoa com os dados preenchidos.
    }
}
