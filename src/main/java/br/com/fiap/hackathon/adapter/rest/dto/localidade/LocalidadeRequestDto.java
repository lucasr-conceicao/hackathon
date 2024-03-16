package br.com.fiap.hackathon.adapter.rest.dto.localidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class LocalidadeRequestDto {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("endereco")
    private UUID endereco;
}
