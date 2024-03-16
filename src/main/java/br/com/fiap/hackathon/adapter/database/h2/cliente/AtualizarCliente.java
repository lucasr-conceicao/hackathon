package br.com.fiap.hackathon.adapter.database.h2.cliente;

import br.com.fiap.hackathon.adapter.database.domain.GestaoCliente;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.ClienteRepository;
import br.com.fiap.hackathon.usecase.database.cliente.ClienteRequest;
import br.com.fiap.hackathon.usecase.database.cliente.ClienteResponse;
import br.com.fiap.hackathon.usecase.database.cliente.IAtualizarCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarCliente implements IAtualizarCliente {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse atualizarCliente(ClienteRequest request, UUID clienteId) {
        var cliente = montarCliente(request, clienteId);
        clienteRepository.save(cliente);
        return converterResponse(cliente);
    }

    private GestaoCliente montarCliente(ClienteRequest request, UUID clienteId) {
        var cliente = buscarCliente(clienteId);
        cliente.setPaisOrigem(request.getPaisOrigem());
        cliente.setCadastroPessoaFisica(request.getCadastroPessoaFisica());
        cliente.setNumeroPassaporte(request.getNumeroPassaporte());
        cliente.setNomeCompleto(request.getNomeCompleto());
        cliente.setDataNascimento(request.getDataNascimento());
        cliente.setEndereco(request.getEndereco());
        cliente.setTelefone(request.getTelefone());
        cliente.setEmail(request.getEmail());
        return cliente;
    }

    private GestaoCliente buscarCliente(UUID clienteId) {
        return clienteRepository.findById(clienteId).orElseThrow(
                () -> new RecursoNaoEncontradoException("O cliente " + clienteId + "nao foi encontrado."));
    }

    private ClienteResponse converterResponse(GestaoCliente response) {
        return ClienteResponse.builder()
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