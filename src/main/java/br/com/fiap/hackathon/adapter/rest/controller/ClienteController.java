package br.com.fiap.hackathon.adapter.rest.controller;

import br.com.fiap.hackathon.adapter.rest.dto.cliente.ClienteRequestDto;
import br.com.fiap.hackathon.adapter.rest.dto.cliente.ClienteResponseDto;
import br.com.fiap.hackathon.usecase.database.cliente.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/gestao-clientes/v1")
@RequiredArgsConstructor
public class ClienteController {

    private final IAtualizarCliente atualizarCliente;
    private final ICadastrarCliente cadastrarCliente;
    private final IDeletarCliente deletarCliente;
    private final IBuscarCliente buscarCliente;

    @PostMapping("/cliente")
    public ResponseEntity<ClienteResponseDto> cadastrarCliente(@RequestBody ClienteRequestDto requestDto) {
        var response = cadastrarCliente.cadastrarCliente(montarRequest(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<ClienteResponseDto> buscarClienteId(@PathVariable(value = "clienteId") UUID clienteId) {
        var response = buscarCliente.buscarCliente(clienteId);
        return ResponseEntity.status(HttpStatus.OK).body(converterResponse(response));
    }

    @PutMapping("/cliente/{clienteId}")
    public ResponseEntity<ClienteResponseDto> atualizarCliente(@RequestBody ClienteRequestDto requestDto,
                                                            @PathVariable(value = "clienteId") UUID clienteId) {
        var response = atualizarCliente.atualizarCliente(montarRequest(requestDto), clienteId);
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @DeleteMapping("/cliente/{clienteId}")
    public ResponseEntity<Void> deletarCliente(@PathVariable(value = "clienteId") UUID clienteId) {
        deletarCliente.deletarCliente(clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private ClienteRequest montarRequest(ClienteRequestDto requestDto) {
        return ClienteRequest.builder()
                .paisOrigem(requestDto.getPaisOrigem())
                .cadastroPessoaFisica(requestDto.getCadastroPessoaFisica())
                .numeroPassaporte(requestDto.getNumeroPassaporte())
                .nomeCompleto(requestDto.getNomeCompleto())
                .dataNascimento(requestDto.getDataNascimento())
                .endereco(requestDto.getEndereco())
                .telefone(requestDto.getTelefone())
                .email(requestDto.getEmail())
                .build();
    }

    private ClienteResponseDto converterResponse(ClienteResponse response) {
        return ClienteResponseDto.builder()
                .clienteId(response.getClienteId())
                .paisOrigem(response.getPaisOrigem())
                .cadastroPessoaFisica(response.getCadastroPessoaFisica())
                .numeroPassaporte(response.getNumeroPassaporte())
                .nomeCompleto(response.getNomeCompleto())
                .dataNascimento(response.getDataNascimento())
                .endereco(response.getEndereco())
                .telefone(response.getTelefone())
                .email(response.getEmail())
                .build();
    }
}