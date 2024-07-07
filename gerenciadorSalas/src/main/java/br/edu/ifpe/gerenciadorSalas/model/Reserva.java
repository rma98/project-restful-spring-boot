package br.edu.ifpe.gerenciadorSalas.model;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Reserva {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private String servidor; // Nome ou ID do servidor que fez a reserva
}
