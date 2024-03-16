package br.com.fiap.hackathon.adapter.rest.dto.localidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalidadeResponseDto {

    @JsonProperty("localidade_id")
    private UUID localidadeId;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("endereco")
    private UUID endereco;
}
