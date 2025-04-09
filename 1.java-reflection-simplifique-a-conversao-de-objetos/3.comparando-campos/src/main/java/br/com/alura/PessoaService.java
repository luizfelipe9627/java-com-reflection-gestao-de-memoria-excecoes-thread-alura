package br.com.alura;

public class PessoaService {

    // Criado um método list que retorna um objeto da classe PessoaDTO.
    public PessoaDTO list() {
        Pessoa pessoa = new PessoaRepository().list(); // Instanciando um objeto da classe PessoaRepository e chamando o método list.
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getNome(), pessoa.getCpf()); // Instanciando um objeto da classe PessoaDTO e passando os valores do objeto pessoa.
        return pessoaDTO; // Retornando o objeto pessoaDTO.
    }
}