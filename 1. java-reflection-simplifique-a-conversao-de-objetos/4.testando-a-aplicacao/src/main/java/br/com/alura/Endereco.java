package br.com.alura;

public class Endereco {

  private String rua; // Criado um atributo do tipo String que é responsável por armazenar o nome da rua.
  private Integer numero; // Criado um atributo do tipo Integer que é responsável por armazenar o número da casa.

  // Método construtor que recebe como parâmetro o nome da rua e o número da casa.
  public Endereco(String rua, Integer numero) {
    this.rua = rua; // Atribui o valor do parâmetro rua ao atributo rua.
    this.numero = numero; // Atribui o valor do parâmetro numero ao atributo numero.
  }

}
