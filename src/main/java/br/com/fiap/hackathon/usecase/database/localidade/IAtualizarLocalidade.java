package br.com.fiap.hackathon.usecase.database.localidade;

import java.util.UUID;

public interface IAtualizarLocalidade {

    LocalidadeResponse atualizarLocalidade(LocalidadeRequest request, UUID localidadeId);
}
