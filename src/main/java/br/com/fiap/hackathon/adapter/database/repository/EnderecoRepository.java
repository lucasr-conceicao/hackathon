package br.com.fiap.hackathon.adapter.database.repository;

import br.com.fiap.hackathon.adapter.database.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
}
