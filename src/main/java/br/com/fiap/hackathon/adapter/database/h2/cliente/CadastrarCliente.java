package br.com.fiap.hackathon.adapter.database.h2.cliente;

import br.com.fiap.hackathon.adapter.database.domain.GestaoCliente;
import br.com.fiap.hackathon.adapter.database.repository.ClienteRepository;
import br.com.fiap.hackathon.usecase.database.cliente.ClienteRequest;
import br.com.fiap.hackathon.usecase.database.cliente.ClienteResponse;
import br.com.fiap.hackathon.usecase.database.cliente.ICadastrarCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarCliente implements ICadastrarCliente {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public ClienteResponse cadastrarCliente(ClienteRequest request) {
        var cliente = montarCliente(request);
        clienteRepository.save(cliente);
        return converterResponse(cliente);
    }

    private GestaoCliente montarCliente(ClienteRequest request) {
        return GestaoCliente.builder()
                .clienteId(UUID.randomUUID())
                .paisOrigem(request.getPaisOrigem())
                .cadastroPessoaFisica(request.getCadastroPessoaFisica())
                .numeroPassaporte(request.getNumeroPassaporte())
                .nomeCompleto(request.getNomeCompleto())
                .dataNascimento(request.getDataNascimento())
                .endereco(request.getEndereco())
                .telefone(request.getTelefone())
                .email(request.getEmail())
                .build();
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