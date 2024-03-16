package br.com.fiap.hackathon.adapter.database.h2.localidade;

import br.com.fiap.hackathon.adapter.database.domain.Endereco;
import br.com.fiap.hackathon.adapter.database.domain.GestaoCliente;
import br.com.fiap.hackathon.adapter.database.domain.Localidade;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.EnderecoRepository;
import br.com.fiap.hackathon.adapter.database.repository.LocalidadeRepository;
import br.com.fiap.hackathon.usecase.database.cliente.ClienteResponse;
import br.com.fiap.hackathon.usecase.database.localidade.IAtualizarLocalidade;
import br.com.fiap.hackathon.usecase.database.localidade.LocalidadeRequest;
import br.com.fiap.hackathon.usecase.database.localidade.LocalidadeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarLocalidade implements IAtualizarLocalidade {

    private final LocalidadeRepository localidadeRepository;
    private final EnderecoRepository enderecoRepository;

    @Override
    public LocalidadeResponse atualizarLocalidade(LocalidadeRequest request, UUID localidadeId) {
        var localidade = montarCliente(request, localidadeId);
        localidadeRepository.save(localidade);
        return converterResponse(localidade);
    }

    private Localidade montarCliente(LocalidadeRequest request, UUID localidadeId) {
        var localidade = buscarLocalidade(localidadeId);
        var endereco = buscarEndereco(request.getEndereco());
        localidade.setNome(request.getNome());
        localidade.setEndereco(endereco);
        return localidade;
    }

    private Localidade buscarLocalidade(UUID localidadeId) {
        return localidadeRepository.findById(localidadeId).orElseThrow(
                () -> new RecursoNaoEncontradoException("A localidade " + localidadeId + "nao foi encontrado."));
    }

    private Endereco buscarEndereco(UUID enderecoId) {
        return enderecoRepository.findById(enderecoId).orElseThrow(
                () -> new RecursoNaoEncontradoException("O endereco " + enderecoId + "nao foi encontrado."));
    }

    private LocalidadeResponse converterResponse(Localidade response) {
        return LocalidadeResponse.builder()
                .localidadeId(response.getLocalidadeId())
                .endereco(response.getEndereco().getEnderecoId())
                .nome(response.getNome())
                .build();
    }
}
