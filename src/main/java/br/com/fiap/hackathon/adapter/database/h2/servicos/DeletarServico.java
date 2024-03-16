package br.com.fiap.hackathon.adapter.database.h2.servicos;

import br.com.fiap.hackathon.adapter.database.domain.GestaoServicos;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.ServicoRepository;
import br.com.fiap.hackathon.usecase.database.servico.IDeletarServico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeletarServico implements IDeletarServico {

    private final ServicoRepository servicoRepository;

    @Override
    public void deletarServico(String servicoId) {
        var servico = servicoRepository.findById(servicoId);
        var servicoValidado = validarServico(servico, servicoId);
        servicoRepository.delete(servicoValidado.get());
    }

    private Optional<GestaoServicos> validarServico(Optional<GestaoServicos> response, String servicoId) {
        if (!response.isPresent())
            throw new RecursoNaoEncontradoException("O recurso " + servicoId + " não foi encontrado.");
        return response;
    }
}
