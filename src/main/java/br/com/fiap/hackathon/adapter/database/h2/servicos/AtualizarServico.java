package br.com.fiap.hackathon.adapter.database.h2.servicos;

import br.com.fiap.hackathon.adapter.database.domain.GestaoServicos;
import br.com.fiap.hackathon.adapter.database.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.hackathon.adapter.database.repository.ServicoRepository;
import br.com.fiap.hackathon.usecase.database.servico.IAtualizarServico;
import br.com.fiap.hackathon.usecase.database.servico.ServicoRequest;
import br.com.fiap.hackathon.usecase.database.servico.ServicoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizarServico implements IAtualizarServico {

    private final ServicoRepository servicoRepository;

    @Override
    public ServicoResponse atualizarServico(ServicoRequest request, String servicoId) {
        var servico = montarServico(request, servicoId);
        servicoRepository.save(servico);
        return converterResponse(servico);
    }

    private GestaoServicos montarServico(ServicoRequest request, String servicoId) {
        var servico = buscarServico(servicoId);
        servico.setDescricao(request.getDescricao());
        servico.setPreco(request.getPreco());
        return servico;
    }

    private GestaoServicos buscarServico(String servicoId) {
        return servicoRepository.findById(servicoId).orElseThrow(
                () -> new RecursoNaoEncontradoException("O cliente " + servicoId + "nao foi encontrado."));
    }

    private ServicoResponse converterResponse(GestaoServicos response) {
        return ServicoResponse.builder()
                .servicoId(response.getServicosId())
                .descricao(response.getDescricao())
                .preco(response.getPreco())
                .build();
    }
}
