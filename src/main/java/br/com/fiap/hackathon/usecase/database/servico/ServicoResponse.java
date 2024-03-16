package br.com.fiap.hackathon.usecase.database.servico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicoResponse {

    private String servicoId;
    private String descricao;
    private BigDecimal preco;
}
