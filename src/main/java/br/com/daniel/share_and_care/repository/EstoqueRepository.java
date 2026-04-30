package br.com.daniel.share_and_care.repository;

import br.com.daniel.share_and_care.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EstoqueRepository extends JpaRepository<Estoque, UUID> {
    Optional<Estoque> findByItemId(UUID itemId);
}
