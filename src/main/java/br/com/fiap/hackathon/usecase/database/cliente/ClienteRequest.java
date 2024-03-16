package br.com.fiap.hackathon.usecase.database.cliente;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ClienteRequest {

    private String paisOrigem;
    private String cadastroPessoaFisica;
    private String numeroPassaporte;
    private String nomeCompleto;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
}