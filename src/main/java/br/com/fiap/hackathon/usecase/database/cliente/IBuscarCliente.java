package br.com.fiap.hackathon.usecase.database.cliente;

import java.util.UUID;

public interface IBuscarCliente {

    ClienteResponse buscarCliente(UUID clienteId);
}