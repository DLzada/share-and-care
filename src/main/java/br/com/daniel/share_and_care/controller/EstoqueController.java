package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Estoque;
import br.com.daniel.share_and_care.service.EstoqueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estoque")
@AllArgsConstructor
public class EstoqueController {
    private final EstoqueService estoqueService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estoque> listarEstoqueCompleto(){
        return estoqueService.listarEstoqueCompleto();
    }
}
