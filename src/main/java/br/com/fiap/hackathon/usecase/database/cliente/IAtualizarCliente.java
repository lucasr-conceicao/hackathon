package br.com.fiap.hackathon.usecase.database.cliente;

import java.util.UUID;

public interface IAtualizarCliente {

    ClienteResponse atualizarCliente(ClienteRequest request, UUID clienteId);
}