package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Movimentacao;
import br.com.daniel.share_and_care.dto.MovimentacaoRequestDTO;
import br.com.daniel.share_and_care.service.MovimentacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimentacoes")
@AllArgsConstructor
public class MovimentacaoController {
    private final MovimentacaoService movimentacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movimentacao registrar(@RequestBody @Valid MovimentacaoRequestDTO dto){
        return movimentacaoService.registrar(dto);
    }
}
