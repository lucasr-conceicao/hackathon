package br.com.fiap.hackathon.adapter.database.h2.endereco;

import br.com.fiap.hackathon.adapter.database.domain.Endereco;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.EnderecoRepository;
import br.com.fiap.hackathon.usecase.database.endereco.EnderecoResponse;
import br.com.fiap.hackathon.usecase.database.endereco.IBuscarEndereco;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarEndereco implements IBuscarEndereco {

    private final EnderecoRepository repository;

    @Override
    @Transactional
    public EnderecoResponse buscarEndereco(UUID enderecoId) {
        var endereco = repository.findById(enderecoId);
        var enderecoValidado = validaEndereco(endereco, enderecoId);
        return converterResponse(enderecoValidado);
    }

    private Optional<Endereco> validaEndereco(Optional<Endereco> response, UUID endereco) {
        if (!response.isPresent())
            throw new RecursoNaoEncontradoException("O recurso " + endereco + " não foi encontrado na tabela tb_endereco_cnsm_enrg.");
        return response;
    }

    private EnderecoResponse converterResponse(Optional<Endereco> response) {
        return EnderecoResponse.builder()
                .enderecoId(response.get().getEnderecoId())
                .rua(response.get().getRua())
                .numero(response.get().getNumero())
                .cep(response.get().getCep())
                .bairro(response.get().getBairro())
                .cidade(response.get().getCidade())
                .estado(response.get().getEstado())
                .pais(response.get().getPais())
                .build();
    }
}