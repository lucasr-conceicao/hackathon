package br.com.fiap.hackathon.adapter.database.repository;

import br.com.fiap.hackathon.adapter.database.domain.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocalidadeRepository extends JpaRepository<Localidade, UUID> {
}
