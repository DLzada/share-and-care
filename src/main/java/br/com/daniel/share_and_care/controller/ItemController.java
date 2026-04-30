package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Item;
import br.com.daniel.share_and_care.dto.ItemRequestDTO;
import br.com.daniel.share_and_care.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item criar(@RequestBody ItemRequestDTO dto){
        return itemService.salvar(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Item> listarTodos(){
        return itemService.listarTodos();
    }
}
