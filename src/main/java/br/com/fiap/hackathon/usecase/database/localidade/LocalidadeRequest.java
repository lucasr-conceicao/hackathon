package br.com.fiap.hackathon.usecase.database.localidade;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class LocalidadeRequest {

    private String nome;
    private UUID endereco;
}
