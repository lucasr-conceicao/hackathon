package br.com.fiap.hackathon.adapter.rest.controller;

import br.com.fiap.hackathon.adapter.rest.dto.localidade.LocalidadeRequestDto;
import br.com.fiap.hackathon.adapter.rest.dto.localidade.LocalidadeResponseDto;
import br.com.fiap.hackathon.usecase.database.localidade.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class LocalidadeController {

    private final IAtualizarLocalidade atualizarLocalidade;
    private final ICadastrarLocalidade cadastrarLocalidde;
    private final IDeletarLocalidade deletarLocalidade;
    private final IBuscarLocalidade buscarLocalidade;

    @PostMapping("/localidade")
    public ResponseEntity<LocalidadeResponseDto> cadastrarCliente(@RequestBody LocalidadeRequestDto requestDto) {
        var response = cadastrarLocalidde.cadastrarLocalidade(montarRequest(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @GetMapping("/localidade/{localidadeId}")
    public ResponseEntity<LocalidadeResponseDto> buscarClienteId(@PathVariable(value = "localidadeId") UUID localidadeId) {
        var response = buscarLocalidade.buscarLocalidade(localidadeId);
        return ResponseEntity.status(HttpStatus.OK).body(converterResponse(response));
    }

    @PutMapping("/localidade/{localidadeId}")
    public ResponseEntity<LocalidadeResponseDto> atualizarCliente(@RequestBody LocalidadeRequestDto requestDto,
                                                               @PathVariable(value = "localidadeId") UUID localidadeId) {
        var response = atualizarLocalidade.atualizarLocalidade(montarRequest(requestDto), localidadeId);
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @DeleteMapping("/localidade/{localidadeId}")
    public ResponseEntity<Void> deletarCliente(@PathVariable(value = "localidadeId") UUID localidadeId) {
        deletarLocalidade.deletarLocalidade(localidadeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private LocalidadeRequest montarRequest(LocalidadeRequestDto requestDto) {
        return LocalidadeRequest.builder()
                .nome(requestDto.getNome())
                .endereco(requestDto.getEndereco())
                .build();
    }

    private LocalidadeResponseDto converterResponse(LocalidadeResponse response) {
        return LocalidadeResponseDto.builder()
                .localidadeId(response.getLocalidadeId())
                .nome(response.getNome())
                .endereco(response.getEndereco())
                .build();
    }
}
