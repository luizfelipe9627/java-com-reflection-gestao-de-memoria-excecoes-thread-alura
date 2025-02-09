package br.com.alura;

import br.com.alura.refl.Transformator;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {

    // Criado um método list que retorna um objeto da classe PessoaDTO.
    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = new PessoaRepository().list(); // Instanciando um objeto da classe PessoaRepository e chamando o método list.
        PessoaDTO pessoaDTO = new Transformator().transform(pessoa); // Instanciando um objeto da classe Transformator que é responsável por transformar o objeto pessoa em um objeto PessoaDTO e armazenando em pessoaDTO.
        return pessoaDTO; // Retornando o objeto pessoaDTO.
    }
}