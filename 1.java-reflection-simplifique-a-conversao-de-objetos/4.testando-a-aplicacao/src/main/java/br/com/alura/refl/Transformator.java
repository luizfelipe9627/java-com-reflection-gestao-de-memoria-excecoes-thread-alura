package br.com.alura.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {
  // Criado um método genérico chamado transform que retorna dois parâmetros, um do tipo I de input e outro do tipo O de output, recebendo como parâmetro um input.
  public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Class<?> source = input.getClass(); // Criado uma variável do tipo Class que não foi especificado o tipo, chamada source que recebe o tipo da source(é o tipo do input).
    Class<?> target = Class.forName(source.getName() + "DTO"); // Criado uma variável do tipo Class que não foi especificado o tipo, chamada o target que recebe o tipo da target(é o tipo do input) e chama o método forName que retorna o nome da classe da source concatenado com a string DTO.

    O targetClass = (O) target.getDeclaredConstructor().newInstance(); // Criado uma variável do tipo O chamada targetClass que recebe o tipo do target e chama o método getDeclaredConstructor que retorna um construtor da classe target e chama o método newInstance passando como parâmetro o input.

    Field[] sourceFields = source.getDeclaredFields(); // Criado um array de Field chamado sourceFields que recebe o tipo do source e chama o método getDeclaredField responsável por retornar um campo da source.
    Field[] targetFields = target.getDeclaredFields(); // Criado um array de Field chamado targetFields que recebe o tipo do target e chama o método getDeclaredField responsável por retornar um campo do target.

    Arrays.stream(sourceFields) // Criado um stream do array de sourceFields.
        .forEach(sourceField -> // Para cada sourceField executar o bloco de código.
            Arrays.stream(targetFields) // Criado um stream do array de targetFields.
                .forEach(targetField -> // Para cada targetField executar o bloco de código.
                    {
                      validate(sourceField, targetField); // Chama o método validate passando como parâmetro o sourceField e o targetField.

                      // O bloco try-catch é utilizado para capturar exceções, o try tenta executar o bloco de código e o catch captura a exceção caso ocorra.
                      try {
                        targetField.set(targetClass, sourceField.get(input)); // Seta o valor do targetField no targetClass passando como parâmetro o targetClass e o valor do sourceField no input.
                      } catch (IllegalAccessException e) {
                        e.printStackTrace(); // Imprime o erro.
                      }
                    }
                )
        );

    return targetClass; // Retornando o objeto targetClass.
  }

  // Criado um método privado chamado validate que retorna quatro parâmetros, um do tipo Field de sourceFields, um do tipo Field de targetField, um do tipo I de input e um do tipo O de targetClass.
  private void validate(Field sourceField, Field targetField) {

    // Se o nome do campo da source for igual ao nome do campo do target e o tipo do campo da source for igual ao tipo do campo do target então executar o bloco de código.
    if (sourceField.getName().equals(targetField.getName())
        && sourceField.getType().equals(targetField.getType())) {
      sourceField.setAccessible(true); // Acessa o campo da source e seta o valor do campo da source no campo do target.
      targetField.setAccessible(true); // Acessa o campo do target e seta o valor do campo da source no campo do target.
    }
  }
}
