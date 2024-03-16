package br.com.fiap.hackathon.adapter.database.h2.localidade;

import br.com.fiap.hackathon.adapter.database.domain.Endereco;
import br.com.fiap.hackathon.adapter.database.domain.Localidade;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.EnderecoRepository;
import br.com.fiap.hackathon.adapter.database.repository.LocalidadeRepository;
import br.com.fiap.hackathon.usecase.database.localidade.ICadastrarLocalidade;
import br.com.fiap.hackathon.usecase.database.localidade.LocalidadeRequest;
import br.com.fiap.hackathon.usecase.database.localidade.LocalidadeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarLocalidade implements ICadastrarLocalidade {

    private final LocalidadeRepository localidadeRepository;
    private final EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public LocalidadeResponse cadastrarLocalidade(LocalidadeRequest request) {
        var localidade = montarLocalidade(request);
        localidadeRepository.save(localidade);
        return converterResponse(localidade);
    }

    private Localidade montarLocalidade(LocalidadeRequest request) {
        var endereco = buscarEndereco(request.getEndereco());
        return Localidade.builder()
                .localidadeId(UUID.randomUUID())
                .nome(request.getNome())
                .endereco(endereco)
                .build();
    }

    @Transactional(readOnly = true)
    private Endereco buscarEndereco(UUID enderecoId) {
        return enderecoRepository.findById(enderecoId).orElseThrow(
                () -> new RecursoNaoEncontradoException("O recurso " +enderecoId + " nao foi encontrado."));
    }

    private LocalidadeResponse converterResponse(Localidade response) {
        return LocalidadeResponse.builder()
                .localidadeId(response.getLocalidadeId())
                .nome(response.getNome())
                .endereco(response.getEndereco().getEnderecoId())
                .build();
    }
}
