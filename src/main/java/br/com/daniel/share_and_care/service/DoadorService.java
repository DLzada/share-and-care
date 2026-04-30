package br.com.daniel.share_and_care.service;

import br.com.daniel.share_and_care.domain.Doador;
import br.com.daniel.share_and_care.dto.DoadorRequestDTO;
import br.com.daniel.share_and_care.repository.DoadorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
