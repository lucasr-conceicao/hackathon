package br.com.fiap.hackathon.adapter.database.h2.servicos;

import br.com.fiap.hackathon.adapter.database.domain.GestaoServicos;
import br.com.fiap.hackathon.adapter.database.repository.ServicoRepository;
import br.com.fiap.hackathon.usecase.database.servico.ICadastrarServico;
import br.com.fiap.hackathon.usecase.database.servico.ServicoRequest;
import br.com.fiap.hackathon.usecase.database.servico.ServicoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastrarServico implements ICadastrarServico {

    private final ServicoRepository servicoRepository;

    @Override
    @Transactional
    public ServicoResponse cadastrarServico(ServicoRequest request) {
        var servico = montarServico(request);
        servicoRepository.save(servico);
        return converterResponse(servico);
    }

    private GestaoServicos montarServico(ServicoRequest request) {
        return GestaoServicos.builder()
                .servicosId(request.getServicoId())
                .descricao(request.getDescricao())
                .preco(request.getPreco())
                .build();
    }

    private ServicoResponse converterResponse(GestaoServicos response) {
        return ServicoResponse.builder()
                .servicoId(response.getServicosId())
                .descricao(response.getDescricao())
                .preco(response.getPreco())
                .build();
    }
}
