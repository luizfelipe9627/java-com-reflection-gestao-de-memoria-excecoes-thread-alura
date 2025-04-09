package br.com.alura.refl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ObjectToJson {
  // Criado um método chamado transform que retorna um parâmetro do tipo String, recebendo como parâmetro um objeto.
  public String transform(Object object) {
    String result = null; // Criado uma variável do tipo String chamada result que recebe null.

    ObjectMapper objectMapper = new ObjectMapper(); // Criado uma variável do tipo ObjectMapper chamada objectMapper que recebe uma nova instância de ObjectMapper responsável por transformar objetos em JSON.
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Chama o método enable passando como parâmetro o SerializationFeature.INDENT_OUTPUT que é responsável por identar a saída do JSON.

    Map<String, Object> mapper = new HashMap<>(); // Criado uma variável do tipo Map chamada mapper que recebe um novo HashMap, responsável por mapear chaves e valores.

    Class<?> classToBeTransformed = object.getClass(); // Criado uma variável do tipo Class que não foi especificado o tipo, chamada classToBeTransformed que recebe o tipo do objeto.

    Arrays.stream(classToBeTransformed.getDeclaredFields()) // Criado um stream do array de campos da classe.
        .forEach(field -> // Para cada campo executar o bloco de código.
            {
              field.setAccessible(true); // Permite que o campo seja acessado.
              String key = field.getName(); // Criado uma variável do tipo String chamada key que recebe o nome do campo.
              Object value = null; // Criado uma variável do tipo Object chamada value que recebe null.

              // O bloco try-catch é utilizado para capturar exceções, o try tenta executar o bloco de código e o catch captura a exceção caso ocorra.
              try {
                value = field.get(object); // Pega o valor do campo no objeto e atribui a variável value.
              } catch (IllegalAccessException e) {
                e.printStackTrace(); // Imprime o erro.
              }

              mapper.put(key, value); // Adiciona a chave e o valor no mapper.
            }
        );

    // O bloco try-catch é utilizado para capturar exceções, o try tenta executar o bloco de código e o catch captura a exceção caso ocorra.
    try {
      result = objectMapper.writeValueAsString(mapper); // Chama o método writeValueAsString passando como parâmetro o mapper e armazena o JSON na variável result.
    } catch (Exception e) {
      e.printStackTrace(); // Imprime o erro.
    }

    return result; // Retorna o JSON.
  }
}
