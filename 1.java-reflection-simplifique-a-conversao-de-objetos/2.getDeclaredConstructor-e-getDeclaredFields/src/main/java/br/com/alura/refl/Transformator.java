package br.com.alura.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformator {
    // Criado um método genérico chamado transform que retorna dois parâmetros, um do tipo I de input e outro do tipo O de output, recebendo como parâmetro um input.
    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass(); // Criado uma variável do tipo Class que não foi especificado o tipo, chamada source que recebe o tipo da source(é o tipo do input).
        Class<?> target = Class.forName(source + "DTO"); // Criado uma variável do tipo Class que não foi especificado o tipo, chamada o target que recebe o tipo da target(é o tipo da source concatenado com DTO).
        O targetClass = (O) target.getDeclaredConstructor(source).newInstance(input); // Criado uma variável do tipo O chamada targetClass que recebe um objeto do tipo target chamando o método getDeclaredConstructor responsável por retornar um construtor da source target passando como parâmetro a source do input e chamando o método newInstance que cria uma nova instância do objeto target passando como parâmetro o input.

        Field[] sourceFields = source.getDeclaredFields(); // Criado um array de Field chamado sourceFields que recebe o tipo do source e chama o método getDeclaredField responsável por retornar um campo da source.
        Field[] targetFields = target.getDeclaredFields(); // Criado um array de Field chamado targetFields que recebe o tipo do target e chama o método getDeclaredField responsável por retornar um campo do target.

        return targetClass; // Retornando o objeto targetClass.
    }
}
