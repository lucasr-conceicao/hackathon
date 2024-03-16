package br.com.fiap.hackathon.usecase.database.endereco;

import java.util.UUID;

public interface IBuscarEndereco {

    EnderecoResponse buscarEndereco(UUID enderecoId);
}
