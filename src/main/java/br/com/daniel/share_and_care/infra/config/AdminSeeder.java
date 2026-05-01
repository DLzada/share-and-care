package br.com.daniel.share_and_care.infra.config;

import br.com.daniel.share_and_care.domain.Usuario;
import br.com.daniel.share_and_care.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdminSeeder implements CommandLineRunner {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(usuarioRepository.findByLogin("admin") == null){
            Usuario admin = new Usuario();
            admin.setLogin("admin");
            admin.setSenha(passwordEncoder.encode("123456"));

            usuarioRepository.save(admin);
        }
    }
}
