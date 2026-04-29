package br.com.daniel.share_and_care.service;

import br.com.daniel.share_and_care.domain.Categoria;
import br.com.daniel.share_and_care.dto.CategoriaRequestDTO;
import br.com.daniel.share_and_care.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria salvar(CategoriaRequestDTO dto){
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());
        categoria.setAtivo(true);

        return categoriaRepository.save(categoria);
    }
}
