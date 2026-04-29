package br.com.daniel.share_and_care.service;

import br.com.daniel.share_and_care.domain.Categoria;
import br.com.daniel.share_and_care.dto.CategoriaRequestDTO;
import br.com.daniel.share_and_care.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public List<Categoria> listarTodas(){
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria nao Encontrada!"));
    }

    @Transactional
    public Categoria atualizar(Long id, CategoriaRequestDTO dto){
        Categoria categoria = buscarPorId(id);

        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());

        return categoriaRepository.save(categoria);
    }
}
