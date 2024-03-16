package br.com.fiap.hackathon.usecase.database.servico;

public interface IAtualizarServico {

    ServicoResponse atualizarServico(ServicoRequest request, String servicoId);
}
