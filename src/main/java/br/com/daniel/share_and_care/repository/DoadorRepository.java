package br.com.daniel.share_and_care.repository;

import br.com.daniel.share_and_care.domain.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, UUID> {
}
