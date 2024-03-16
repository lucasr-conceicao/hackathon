package br.com.fiap.hackathon.adapter.rest.dto.servico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicoResponseDto {

    private String servicoId;
    private String descricao;
    private BigDecimal preco;
}
