package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Categoria;
import br.com.daniel.share_and_care.dto.CategoriaRequestDTO;
import br.com.daniel.share_and_care.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria criar(@RequestBody @Valid CategoriaRequestDTO dto){
        return categoriaService.salvar(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listarTodas(){
        return categoriaService.listarTodas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria atualizar(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaRequestDTO dto){
        return categoriaService.atualizar(id, dto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        categoriaService.deletar(id);
    }
}
