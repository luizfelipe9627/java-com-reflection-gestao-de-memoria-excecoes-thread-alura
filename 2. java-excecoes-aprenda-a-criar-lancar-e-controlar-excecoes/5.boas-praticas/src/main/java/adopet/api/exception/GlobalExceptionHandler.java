package adopet.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

// A anotação @RestControllerAdvice é utilizada para definir um componente global que irá tratar exceções lançadas por métodos anotados com @RequestMapping e @ExceptionHandler.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // A anotação @ExceptionHandler é utilizada para definir que o método adocaoException irá tratar exceções do tipo AdocaoException.
    @ExceptionHandler(AdocaoException.class)
    // O método adocaoException é responsável por tratar exceções do tipo AdocaoException.
    public ResponseEntity<ResponseError> adocaoException(Exception e) {
        // Cria um objeto do tipo ResponseError com a mensagem da exceção, status 400 e a data e hora atual.
        ResponseError response = new ResponseError(
            e.getMessage(),
            HttpStatus.BAD_REQUEST,
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // Retorna um status 400 com a mensagem da exceção.
    }

    // A anotação @ExceptionHandler é utilizada para definir que o método trataException irá tratar exceções do tipo Exception.
    @ExceptionHandler(Exception.class)
    // O método trataException é responsável por tratar exceções do tipo Exception.
    public ResponseEntity<ResponseError> trataException(Exception e) {
        // Cria um objeto do tipo ResponseError com a mensagem da exceção, o status recebido como parâmetro e a data e hora atual.
        ResponseError response = new ResponseError(
            e.getMessage(),
            HttpStatus.BAD_REQUEST,
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // Retorna um status 400 com a mensagem da exceção.
    }
}
