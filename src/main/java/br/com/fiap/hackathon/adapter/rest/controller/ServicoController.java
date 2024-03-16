package br.com.fiap.hackathon.adapter.rest.controller;

import br.com.fiap.hackathon.adapter.rest.dto.servico.ServicoRequestDto;
import br.com.fiap.hackathon.adapter.rest.dto.servico.ServicoResponseDto;
import br.com.fiap.hackathon.usecase.database.servico.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestao-servicos/v1")
@RequiredArgsConstructor
public class ServicoController {

    private final IAtualizarServico atualizarServico;
    private final ICadastrarServico cadastrarServico;
    private final IDeletarServico deletarServico;
    private final IBuscarServico buscarServico;

    @PostMapping("/servico")
    public ResponseEntity<ServicoResponseDto> cadastrarServico(@RequestBody ServicoRequestDto requestDto) {
        var response = cadastrarServico.cadastrarServico(montarRequest(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @GetMapping("/servicos/{servicoId}")
    public ResponseEntity<ServicoResponseDto> buscarServicoId(@PathVariable(value = "servicoId") String servicoId) {
        var response = buscarServico.buscarServico(servicoId);
        return ResponseEntity.status(HttpStatus.OK).body(converterResponse(response));
    }

    @PutMapping("/servicos/{servicoId}")
    public ResponseEntity<ServicoResponseDto> atualizarServico(@RequestBody ServicoRequestDto requestDto,
                                                            @PathVariable(value = "servicoId") String servicoId) {
        var response = atualizarServico.atualizarServico(montarRequest(requestDto), servicoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @DeleteMapping("/servicos/{servicoId}")
    public ResponseEntity<Void> deletarServico(@PathVariable(value = "servicoId") String servicoId) {
        deletarServico.deletarServico(servicoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private ServicoRequest montarRequest(ServicoRequestDto requestDto) {
        return ServicoRequest.builder()
                .servicoId(requestDto.getServicoId())
                .descricao(requestDto.getDescricao())
                .preco(requestDto.getPreco())
                .build();
    }

    private ServicoResponseDto converterResponse(ServicoResponse response) {
        return ServicoResponseDto.builder()
                .servicoId(response.getServicoId())
                .descricao(response.getDescricao())
                .preco(response.getPreco())
                .build();
    }
}
