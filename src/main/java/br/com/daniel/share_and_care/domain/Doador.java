package br.com.daniel.share_and_care.domain;

import br.com.daniel.share_and_care.domain.enums.TipoDoador;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "doadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doador {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(length = 100)
    private String contato;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_doador", nullable = false)
    private TipoDoador tipoDoador;

    @CreationTimestamp
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
}
