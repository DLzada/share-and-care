package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Doador;
import br.com.daniel.share_and_care.dto.DoadorRequestDTO;
import br.com.daniel.share_and_care.service.DoadorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doadores")
@AllArgsConstructor
public class DoadorController {
    private final DoadorService doadorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doador salvar(@RequestBody @Valid DoadorRequestDTO dto){
        return doadorService.salvar(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Doador> listarTodos(){
        return doadorService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doador buscarPorId(@PathVariable UUID id){
        return doadorService.buscarPorId(id);
    }
}
