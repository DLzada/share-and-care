package br.com.daniel.share_and_care.service;

import br.com.daniel.share_and_care.domain.Estoque;
import br.com.daniel.share_and_care.repository.EstoqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstoqueService {
    private final EstoqueRepository estoqueRepository;

    public List<Estoque> listarEstoqueCompleto(){
        return estoqueRepository.findAll();
    }
}
