package br.com.fiap.hackathon.usecase.database.cliente;

public interface ICadastrarCliente {

    ClienteResponse cadastrarCliente(ClienteRequest request);
}