package adopet.api.exception;

// Criação da classe AdocaoException que extende a classe RuntimeException fazendo com que seja uma exceção não verificada.
public class AdocaoException extends RuntimeException {
    // Construtor que recebe uma mensagem e repassa para o construtor da superclasse(a classe RuntimeException).
    public AdocaoException(String message) {
        super(message); // Repassa a mensagem para o construtor da superclasses(a classe RuntimeException).
    }
}
