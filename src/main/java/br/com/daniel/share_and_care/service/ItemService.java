package br.com.daniel.share_and_care.service;

import br.com.daniel.share_and_care.domain.Categoria;
import br.com.daniel.share_and_care.domain.Item;
import br.com.daniel.share_and_care.dto.ItemRequestDTO;
import br.com.daniel.share_and_care.infra.exception.BusinessException;
import br.com.daniel.share_and_care.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final CategoriaService categoriaService;

    @Transactional
    public Item salvar(ItemRequestDTO dto){
        Categoria categoria = categoriaService.buscarPorId(dto.categoriaId());

        Item item = new Item();
        item.setNome(dto.nome());
        item.setUnidadeMedida(dto.unidadeMedida());
        item.setCategoria(categoria);

        return itemRepository.save(item);
    }

    public List<Item> listarTodos(){
        return itemRepository.findAll();
    }

    public Item buscarPorId(UUID id){
        return itemRepository.findById(id)
                .orElseThrow(()-> new BusinessException("Item com ID %s não encontrado", id.toString()));
    }
}
