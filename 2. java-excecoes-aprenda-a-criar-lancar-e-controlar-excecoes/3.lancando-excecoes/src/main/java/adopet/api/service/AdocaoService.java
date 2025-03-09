package adopet.api.service;

import adopet.api.dto.*;
import adopet.api.model.Adocao;
import adopet.api.model.Pet;
import adopet.api.model.StatusAdocao;
import adopet.api.model.Tutor;
import adopet.api.repository.AdocaoRepository;
import adopet.api.repository.PetRepository;
import adopet.api.repository.TutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdocaoService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private AdocaoRepository adocaoRepository;

    public List<AdocaoDTO> listarTodos(){

        return adocaoRepository.findAll().stream().map(AdocaoDTO::new).toList();
    }
    public AdocaoDTO listar(Long id){

        return adocaoRepository.findById(id).stream().findFirst().map(AdocaoDTO::new).orElse(null);
    }

    public void solicitar(SolicitacaoDeAdocaoDTO dto){
        Pet pet = petRepository.getReferenceById(dto.idPet());
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());

        // Validação -> Pet já adotado.
        // Se o pet já foi adotado, uma exceção é lançada.
        if(pet.getAdotado()){
            throw new IllegalStateException("Pet já adotado."); // Lança uma exceção do tipo IllegalStateException com a mensagem "Pet já adotado."
        }

        // Validação -> Pet com solicitação de adoção em andamento.
        Boolean petAdocaoEmAndamento = adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO); // Verifica se existe uma solicitação de adoção em andamento para o pet.
        // Se existir uma solicitação de adoção em andamento para o pet, uma exceção é lançada.
        if(petAdocaoEmAndamento){
            throw new UnsupportedOperationException("Pet com adoção em andamento."); // Lança uma exceção do tipo UnsupportedOperationException com a mensagem "Pet com adoção em andamento."
        }

        // Validação -> Tutor com 2 adoções aprovadas.
        Integer tutorAdocoes = adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO); // Conta quantas adoções aprovadas o tutor possui.
        // Se o tutor já possui 2 adoções aprovadas, uma exceção é lançada.
        if(tutorAdocoes == 2){
            throw new IllegalStateException("Tutor já possui 2 adoções aprovadas."); // Lança uma exceção do tipo IllegalStateException com a mensagem "Tutor já possui 2 adoções aprovadas."
        }

        adocaoRepository.save(new Adocao(tutor,pet, dto.motivo()));
    }

    public void aprovar(AprovarAdocaoDTO dto){
        Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());
        adocao.marcarComoAprovada();
        adocao.getPet().marcarComoAdotado();
    }

    public void reprovar(ReprovarAdocaoDTO dto){
        Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());
        adocao.marcarComoReprovada(dto.justificativa());
    }
}
