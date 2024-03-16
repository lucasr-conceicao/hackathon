package br.com.fiap.hackathon.adapter.database.h2.endereco;

import br.com.fiap.hackathon.adapter.database.domain.Endereco;
import br.com.fiap.hackathon.adapter.database.repository.EnderecoRepository;
import br.com.fiap.hackathon.usecase.database.endereco.EnderecoRequest;
import br.com.fiap.hackathon.usecase.database.endereco.EnderecoResponse;
import br.com.fiap.hackathon.usecase.database.endereco.ICadastrarEndereco;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastrarEndereco implements ICadastrarEndereco {

    private final EnderecoRepository repository;

    @Override
    @Transactional
    public EnderecoResponse cadastrarEndereco(EnderecoRequest request) {
        var endereco = montarEnderecoRequest(request);
        repository.save(endereco);
        return converterResponse(endereco);
    }

    private Endereco montarEnderecoRequest(EnderecoRequest request) {
        return Endereco.builder()
                .rua(request.getRua())
                .numero(request.getNumero())
                .cep(request.getCep())
                .bairro(request.getBairro())
                .cidade(request.getCidade())
                .estado(request.getEstado())
                .pais(request.getPais())
                .build();
    }

    private EnderecoResponse converterResponse(Endereco response) {
        return EnderecoResponse.builder()
                .enderecoId(response.getEnderecoId())
                .rua(response.getRua())
                .numero(response.getNumero())
                .cep(response.getCep())
                .bairro(response.getBairro())
                .cidade(response.getCidade())
                .estado(response.getEstado())
                .pais(response.getPais())
                .build();
    }
}
