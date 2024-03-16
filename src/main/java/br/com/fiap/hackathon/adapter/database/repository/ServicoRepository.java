package br.com.fiap.hackathon.adapter.database.repository;

import br.com.fiap.hackathon.adapter.database.domain.GestaoServicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<GestaoServicos, String> {
}
