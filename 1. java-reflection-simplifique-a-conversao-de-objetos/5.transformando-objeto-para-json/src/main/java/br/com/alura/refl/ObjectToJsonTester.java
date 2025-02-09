package br.com.alura.refl;

import br.com.alura.Pessoa;

public class ObjectToJsonTester {
    public static void main(String[] args) {
      Pessoa pessoa = new Pessoa(1, "João", "12345"); // Cria um objeto Pessoa com as informações passadas.
      ObjectToJson objectToJson = new ObjectToJson(); // Cria uma instância de ObjectToJson responsável por converter um objeto em JSON.
      String json = objectToJson.transform(pessoa); // Trasforma o objeto pessoa em JSON.
      System.out.println(json); // Imprime o JSON gerado.
    }
}
