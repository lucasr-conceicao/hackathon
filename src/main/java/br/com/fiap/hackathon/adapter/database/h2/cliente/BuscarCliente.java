package br.com.fiap.hackathon.adapter.database.h2.cliente;

import br.com.fiap.hackathon.adapter.database.domain.GestaoCliente;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.ClienteRepository;
import br.com.fiap.hackathon.usecase.database.cliente.ClienteResponse;
import br.com.fiap.hackathon.usecase.database.cliente.IBuscarCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarCliente implements IBuscarCliente {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse buscarCliente(UUID clienteId) {
        var cliente = clienteRepository.findById(clienteId);
        var clienteValidado = validarCliente(cliente, clienteId);
        return converterResponse(clienteValidado);
    }

    private Optional<GestaoCliente> validarCliente(Optional<GestaoCliente> response, UUID clienteId) {
        if (!response.isPresent())
            throw new RecursoNaoEncontradoException("O recurso " + clienteId + " não foi encontrado.");
        return response;
    }

    private ClienteResponse converterResponse(Optional<GestaoCliente> response) {
        return ClienteResponse.builder()
                .clienteId(response.get().getClienteId())
                .paisOrigem(response.get().getPaisOrigem())
                .cadastroPessoaFisica(response.get().getCadastroPessoaFisica())
                .numeroPassaporte(response.get().getNumeroPassaporte())
                .nomeCompleto(response.get().getNomeCompleto())
                .dataNascimento(response.get().getDataNascimento())
                .endereco(response.get().getEndereco())
                .telefone(response.get().getTelefone())
                .email(response.get().getEmail())
                .build();
    }
}