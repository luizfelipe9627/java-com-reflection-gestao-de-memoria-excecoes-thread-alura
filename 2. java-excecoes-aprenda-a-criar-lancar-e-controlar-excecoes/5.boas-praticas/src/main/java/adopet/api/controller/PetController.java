package adopet.api.controller;

import adopet.api.dto.CadastroPetDTO;
import adopet.api.dto.PetDTO;
import adopet.api.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public ResponseEntity<List<PetDTO>> buscarTodos(){
        List<PetDTO> pets = service.listarTodos();
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestPart @Valid CadastroPetDTO dados,
                                            @RequestParam MultipartFile imagem){
        // O bloco try-catch é utilizado para capturar exceções que podem ocorrer durante a execução do código.
        try {
            service.cadastrar(dados, imagem);
        } // O bloco catch é utilizado para tratar a exceção Exception que pode ocorrer ao chamar o método cadastrar().
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
