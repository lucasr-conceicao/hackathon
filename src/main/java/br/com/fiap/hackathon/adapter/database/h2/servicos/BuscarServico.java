package br.com.fiap.hackathon.adapter.database.h2.servicos;

import br.com.fiap.hackathon.adapter.database.domain.GestaoServicos;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.ServicoRepository;
import br.com.fiap.hackathon.usecase.database.servico.IBuscarServico;
import br.com.fiap.hackathon.usecase.database.servico.ServicoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarServico implements IBuscarServico {

    private final ServicoRepository servicoRepository;

    @Override
    public ServicoResponse buscarServico(String servicoId) {
        var servico = servicoRepository.findById(servicoId);
        var clienteValidado = validarServico(servico, servicoId);
        return converterResponse(clienteValidado);
    }

    private Optional<GestaoServicos> validarServico(Optional<GestaoServicos> response, String servicoId) {
        if (!response.isPresent())
            throw new RecursoNaoEncontradoException("O recurso " + servicoId + " não foi encontrado.");
        return response;
    }

    private ServicoResponse converterResponse(Optional<GestaoServicos> response) {
        return ServicoResponse.builder()
                .servicoId(response.get().getServicosId())
                .descricao(response.get().getDescricao())
                .preco(response.get().getPreco())
                .build();
    }
}
