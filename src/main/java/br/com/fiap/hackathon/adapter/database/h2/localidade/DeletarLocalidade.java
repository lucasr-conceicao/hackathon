package br.com.fiap.hackathon.adapter.database.h2.localidade;

import br.com.fiap.hackathon.adapter.database.domain.Endereco;
import br.com.fiap.hackathon.adapter.database.domain.Localidade;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.LocalidadeRepository;
import br.com.fiap.hackathon.usecase.database.localidade.IDeletarLocalidade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarLocalidade implements IDeletarLocalidade {

    private final LocalidadeRepository localidadeRepository;

    @Override
    public void deletarLocalidade(UUID localidadeId) {
        var localidade = localidadeRepository.findById(localidadeId);
        var localidadeValida = validaEndereco(localidade, localidadeId);
        localidadeRepository.delete(localidadeValida.get());
    }

    private Optional<Localidade> validaEndereco(Optional<Localidade> response, UUID localidade) {
        if (!response.isPresent())
            throw new RecursoNaoEncontradoException("O recurso " + localidade + " não foi encontrado.");
        return response;
    }
}
