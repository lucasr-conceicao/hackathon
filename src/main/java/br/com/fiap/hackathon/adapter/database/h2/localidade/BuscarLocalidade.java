package br.com.fiap.hackathon.adapter.database.h2.localidade;

import br.com.fiap.hackathon.adapter.database.domain.Endereco;
import br.com.fiap.hackathon.adapter.database.domain.Localidade;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.LocalidadeRepository;
import br.com.fiap.hackathon.usecase.database.endereco.EnderecoResponse;
import br.com.fiap.hackathon.usecase.database.localidade.IBuscarLocalidade;
import br.com.fiap.hackathon.usecase.database.localidade.LocalidadeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarLocalidade implements IBuscarLocalidade {

    private final LocalidadeRepository localidadeRepository;

    @Override
    public LocalidadeResponse buscarLocalidade(UUID localidadeId) {
        var localidade = localidadeRepository.findById(localidadeId);
        var localidadeValidada = validaEndereco(localidade, localidadeId);
        return converterResponse(localidadeValidada);
    }

    private Optional<Localidade> validaEndereco(Optional<Localidade> response, UUID localidade) {
        if (!response.isPresent())
            throw new RecursoNaoEncontradoException("O recurso " + localidade + " não foi encontrado na tabela tb_endereco_cnsm_enrg.");
        return response;
    }

    private LocalidadeResponse converterResponse(Optional<Localidade> response) {
        return LocalidadeResponse.builder()
                .endereco(response.get().getEndereco().getEnderecoId())
                .nome(response.get().getNome())
                .localidadeId(response.get().getLocalidadeId())
                .build();
    }
}
