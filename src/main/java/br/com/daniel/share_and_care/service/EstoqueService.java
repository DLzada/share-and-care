package br.com.daniel.share_and_care.service;

import br.com.daniel.share_and_care.domain.Estoque;
import br.com.daniel.share_and_care.repository.EstoqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EstoqueService {
    private final EstoqueRepository estoqueRepository;

    public Page<Estoque> listarEstoqueCompleto(Pageable paginacao){
        return estoqueRepository.findAll(paginacao);
    }
}
