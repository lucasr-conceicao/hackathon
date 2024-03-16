package br.com.fiap.hackathon.adapter.database.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_gestao_cliente")
public class GestaoCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private UUID clienteId;

    @Column(name = "pais_origem", nullable = false)
    private String paisOrigem;

    @Column(name = "cadastro_pessoa_fisica", nullable = false)
    private String cadastroPessoaFisica;

    @Column(name = "numero_passaporte", nullable = false)
    private String numeroPassaporte;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;
}