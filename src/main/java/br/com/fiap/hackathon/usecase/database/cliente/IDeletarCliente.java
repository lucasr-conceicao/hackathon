package br.com.fiap.hackathon.usecase.database.cliente;

import java.util.UUID;

public interface IDeletarCliente {

    void deletarCliente(UUID clienteId);
}