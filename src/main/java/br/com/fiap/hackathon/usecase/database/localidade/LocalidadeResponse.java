package br.com.fiap.hackathon.usecase.database.localidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalidadeResponse {

    private UUID localidadeId;
    private String nome;
    private UUID endereco;
}
