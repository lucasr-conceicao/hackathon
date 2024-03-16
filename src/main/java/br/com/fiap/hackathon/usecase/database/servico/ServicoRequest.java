package br.com.fiap.hackathon.usecase.database.servico;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ServicoRequest {

    private String servicoId;
    private String descricao;
    private BigDecimal preco;
}
