package br.com.fiap.hackathon.adapter.rest.dto.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClienteRequestDto {

    @JsonProperty("pais_origem")
    private String paisOrigem;

    @JsonProperty("cadastro_pessoa_fisica")
    private String cadastroPessoaFisica;

    @JsonProperty("numero_passaporte")
    private String numeroPassaporte;

    @JsonProperty("nome_completo")
    private String nomeCompleto;

    @JsonProperty("data_nascimento")
    private String dataNascimento;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("email")
    private String email;
}