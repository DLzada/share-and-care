package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Usuario;
import br.com.daniel.share_and_care.dto.AuthenticationDTO;
import br.com.daniel.share_and_care.dto.LoginRequestDTO;
import br.com.daniel.share_and_care.infra.security.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AutenticacaoController {
    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginRequestDTO efetuarLogin(@RequestBody @Valid AuthenticationDTO dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return new LoginRequestDTO(tokenJWT);
    }
}
