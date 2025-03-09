package adopet.api.controller;

import adopet.api.dto.AdocaoDTO;
import adopet.api.dto.AprovarAdocaoDTO;
import adopet.api.dto.ReprovarAdocaoDTO;
import adopet.api.dto.SolicitacaoDeAdocaoDTO;
import adopet.api.service.AdocaoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService service;

    @GetMapping
    public ResponseEntity<List<AdocaoDTO>> buscarTodos(){
        List<AdocaoDTO> adocoes = service.listarTodos();
        return ResponseEntity.ok(adocoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdocaoDTO> buscar(@PathVariable Long id){
        AdocaoDTO adocao = service.listar(id);
        return ResponseEntity.ok(adocao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoDeAdocaoDTO dados){
        // O bloco try tenta executar o método solicitar() caso ocorra uma exceção/erro o bloco catch é executado.
        try {
            this.service.solicitar(dados);
        } // O bloco catch é utilizado para tratar a exceção IllegalStateException e UnsupportedOperationException que podem ocorrer ao chamar o método aprovar().
        catch (IllegalStateException | UnsupportedOperationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); // Retorna um status 400 com a mensagem da exceção.
        }

        return ResponseEntity.ok("Adoção solicitada com sucesso!");
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovarAdocaoDTO dto){
        // O bloco try tenta executar o método aprovar() caso ocorra uma exceção/erro o bloco catch é executado.
        try {
            this.service.aprovar(dto);
        } // O bloco catch é utilizado para tratar a exceção EntityNotFoundException que pode ocorrer ao chamar o método aprovar().
        catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adoção não encontrada."); // Retorna um status 404 com a mensagem "Adoção não encontrada."
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovarAdocaoDTO dto){
        this.service.reprovar(dto);
        return ResponseEntity.ok().build();
    }
}
