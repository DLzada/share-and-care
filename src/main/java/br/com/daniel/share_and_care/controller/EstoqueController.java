package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Estoque;
import br.com.daniel.share_and_care.service.EstoqueService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoques")
@AllArgsConstructor
public class EstoqueController {
    private final EstoqueService estoqueService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Estoque> listarEstoqueCompleto(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        return estoqueService.listarEstoqueCompleto(paginacao);
    }
}
