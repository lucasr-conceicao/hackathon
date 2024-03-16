package br.com.fiap.hackathon.adapter.database.h2.endereco;

import br.com.fiap.hackathon.adapter.database.domain.Endereco;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.EnderecoRepository;
import br.com.fiap.hackathon.usecase.database.endereco.EnderecoResponse;
import br.com.fiap.hackathon.usecase.database.endereco.IBuscarEndereco;
import br.com.fiap.hackathon.usecase.database.endereco.IDeletarEndereco;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarEndereco implements IDeletarEndereco {

    private final EnderecoRepository repository;

    @Override
    @Transactional
    public void deletarEndereco(UUID enderecoId) {
        var endereco = repository.findById(enderecoId);
        var enderecoValidado = validaEndereco(endereco, enderecoId);
        repository.delete(enderecoValidado.get());
    }

    private Optional<Endereco> validaEndereco(Optional<Endereco> response, UUID endereco) {
        if (!response.isPresent())
            throw new RecursoNaoEncontradoException("O recurso " + endereco + " não foi encontrado.");
        return response;
    }
}
