package br.com.daniel.share_and_care.service;

import br.com.daniel.share_and_care.domain.Categoria;
import br.com.daniel.share_and_care.dto.CategoriaRequestDTO;
import br.com.daniel.share_and_care.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService (CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Categoria salvar(CategoriaRequestDTO dto){
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());
        categoria.setAtivo(true);

        return categoriaRepository.save(categoria);
    }
}
