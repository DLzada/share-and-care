package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Doador;
import br.com.daniel.share_and_care.dto.DoadorRequestDTO;
import br.com.daniel.share_and_care.service.DoadorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doadores")
@AllArgsConstructor
public class DoadorController {
    private final DoadorService doadorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doador salvar(@RequestBody DoadorRequestDTO dto){
        return doadorService.salvar(dto);
    }
}
