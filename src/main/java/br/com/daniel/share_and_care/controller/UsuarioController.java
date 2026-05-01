package br.com.daniel.share_and_care.controller;

import br.com.daniel.share_and_care.domain.Usuario;
import br.com.daniel.share_and_care.dto.AuthenticationDTO;
import br.com.daniel.share_and_care.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrar(@RequestBody @Valid AuthenticationDTO dados){
        Usuario novoUsuario = new Usuario();
        novoUsuario.setLogin(dados.login());

        novoUsuario.setSenha(passwordEncoder.encode(dados.senha()));

        usuarioRepository.save(novoUsuario);

        return "Usuário " + dados.login() + "criado com sucesso.";
    }

}
