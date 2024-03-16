package br.com.fiap.hackathon.adapter.database.h2.cliente;

import br.com.fiap.hackathon.adapter.database.domain.GestaoCliente;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.ClienteRepository;
import br.com.fiap.hackathon.usecase.database.cliente.IDeletarCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarCliente implements IDeletarCliente {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public void deletarCliente(UUID clienteId) {
        var cliente = clienteRepository.findById(clienteId);
        var clienteValidado = validarCliente(cliente, clienteId);
        clienteRepository.delete(clienteValidado.get());
    }

    private Optional<GestaoCliente> validarCliente(Optional<GestaoCliente> response, UUID clienteId) {
        if (!response.isPresent())
            throw new RecursoNaoEncontradoException("O recurso " + clienteId + " não foi encontrado na tabela tb_endereco_cnsm_enrg.");
        return response;
    }
}