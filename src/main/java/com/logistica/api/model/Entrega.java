package com.logistica.api.model;

import com.logistica.api.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "entregas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "loja_responsavel", nullable = false)
    private String lojaResponsavel;

    @ManyToOne
    @JoinColumn(name = "origem_id")
    private Endereco origem;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Endereco destino;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
