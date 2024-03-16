package br.com.fiap.hackathon.adapter.database.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_localidade")
public class Localidade {

    @Id
    @Column(name = "id_localidade")
    private UUID localidadeId;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
