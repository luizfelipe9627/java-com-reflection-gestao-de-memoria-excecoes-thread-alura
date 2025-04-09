package br.com.alura.refl;

import br.com.alura.Endereco;
import br.com.alura.Pessoa;
import br.com.alura.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {

  Pessoa pessoa = new Pessoa(1, "João", "1234"); // Criado um objeto da classe Pessoa com os dados preenchidos e atribuído à variável pessoa.
  Endereco endereco = new Endereco("Rua 1", 1); // Criado um objeto da classe Endereco com os dados preenchidos e atribuído à variável endereco.

  // A anotação @Test indica que o método é um método de teste.
  @Test
  // Método que testa a transformação de um objeto em um DTO, se transformar corretamente o teste passa.
  public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Transformator transformator = new Transformator(); // Criado um objeto da classe Transformator e atribuído à variável transformator.
    PessoaDTO pessoaDTO = transformator.transform(pessoa); // Chamado o método transform do objeto transformator passando como parâmetro o objeto pessoa e atribuído à variável pessoaDTO.

    Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO); // Verifica se a variável pessoaDTO é uma instância da classe PessoaDTO, se for o teste passa.
    Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome()); // Verifica se o nome da pessoa é igual ao nome da pessoaDTO, se for o teste passa.
    Assertions.assertEquals(pessoa.getCpf(), pessoaDTO.getCpf()); // Verifica se o cpf da pessoa é igual ao cpf da pessoaDTO, se for o teste passa.
  }

  // A anotação @Test indica que o método é um método de teste.
  @Test
  // Método que testa a não transformação de um objeto em um DTO, se não transformar corretamente o teste passa.
  public void shouldNotTransform() {
    // Verifica se o método transform da classe Transformator lança uma exceção do tipo ClassNotFoundException, se lançar o teste passa.
    Assertions.assertThrows(ClassNotFoundException.class, () -> {
      Transformator transformator = new Transformator(); // Criado um objeto da classe Transformator e atribuído à variável transformator.
      transformator.transform(endereco); // Chamado o método transform do objeto transformator passando como parâmetro o objeto endereco.
    });
  }

  // A anotação @Test indica que o método é um método de teste.
  @Test
  // Método que testa a transformação de um objeto em um DTO, se transformar corretamente o teste passa.
  public void shouldTransformWhenSomeFieldsAreNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    pessoa = new Pessoa("João"); // Criado um objeto da classe Pessoa com o nome preenchido e atribuído à variável pessoa.
    Transformator transformator = new Transformator(); // Criado um objeto da classe Transformator e atribuído à variável transformator.
    PessoaDTO pessoaDTOSemCPF = transformator.transform(pessoa); // Chamado o método transform do objeto transformator passando como parâmetro o objeto pessoa e atribuído à variável pessoaDTOSemCPF.

    Assertions.assertEquals(pessoa.getNome(), pessoaDTOSemCPF.getNome()); // Verifica se o nome da pessoa é igual ao nome da pessoaDTOSemCPF, se for o teste passa.
    Assertions.assertNull(pessoaDTOSemCPF.getCpf()); // Verifica se o cpf da pessoaDTOSemCPF é nulo, se for o teste passa.
  }

}
