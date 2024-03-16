package br.com.fiap.hackathon.usecase.database.localidade;

import java.util.UUID;

public interface IBuscarLocalidade {

    LocalidadeResponse buscarLocalidade(UUID localidadeId);
}
