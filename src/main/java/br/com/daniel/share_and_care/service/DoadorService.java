package br.com.daniel.share_and_care.service;

import br.com.daniel.share_and_care.domain.Doador;
import br.com.daniel.share_and_care.dto.DoadorRequestDTO;
import br.com.daniel.share_and_care.infra.exception.BusinessException;
import br.com.daniel.share_and_care.repository.DoadorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DoadorService {
    private final DoadorRepository doadorRepository;

    @Transactional
    public Doador salvar(DoadorRequestDTO dto){
        Doador doador = new Doador();
        doador.setNome(dto.nome());
        doador.setContato(dto.contato());
        doador.setTipoDoador(dto.tipoDoador());

        return doadorRepository.save(doador);
    }

    public List<Doador> listarTodos(){
        return doadorRepository.findAll();
    }

    public Doador buscarPorId(UUID id){
        return doadorRepository.findById(id)
                .orElseThrow(() -> new BusinessException("O doador com o ID %s nao foi encontrado", id.toString()));
    }
}
