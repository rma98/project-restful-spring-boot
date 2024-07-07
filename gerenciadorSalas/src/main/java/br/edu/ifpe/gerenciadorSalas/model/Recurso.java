package br.edu.ifpe.gerenciadorSalas.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Recurso {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
}
