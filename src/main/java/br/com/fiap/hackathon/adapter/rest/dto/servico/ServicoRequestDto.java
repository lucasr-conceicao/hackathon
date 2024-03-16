package br.com.fiap.hackathon.adapter.rest.dto.servico;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ServicoRequestDto {

    @JsonProperty("id_servico")
    private String servicoId;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("preco")
    private BigDecimal preco;

}
