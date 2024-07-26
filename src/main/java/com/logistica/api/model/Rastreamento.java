package com.logistica.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "rastreamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rastreamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(name = "descricao_localizacao", nullable = false)
    private String descricaoLocalizacao;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;
}
