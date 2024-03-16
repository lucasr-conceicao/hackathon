package br.com.fiap.hackathon.usecase.database.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private UUID clienteId;
    private String paisOrigem;
    private String cadastroPessoaFisica;
    private String numeroPassaporte;
    private String nomeCompleto;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
}