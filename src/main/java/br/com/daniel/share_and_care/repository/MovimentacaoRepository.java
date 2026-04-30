package br.com.daniel.share_and_care.repository;

import br.com.daniel.share_and_care.domain.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, UUID> {
}
