package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Categoria;
import br.com.daniel.share_and_care.dto.CategoriaRequestDTO;
import br.com.daniel.share_and_care.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaController {
    private final CategoriaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria criar(@RequestBody @Valid CategoriaRequestDTO dto){
        return service.salvar(dto);
    }
}
