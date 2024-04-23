package br.edu.ifpe.classroomManager.model;

import java.time.LocalDateTime;

import br.edu.ifpe.classroomManager.dto.DadosAdicionaReservaSala;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Table(name = "Reservassalas")
@Data
@Entity(name = "reservassalas")
public class ReservaSala {

	public ReservaSala(DadosAdicionaReservaSala dados) {
		this.titulo=dados.titulo();
		this.descricao=dados.descricao();
		this.dataHora=dados.dataHora();
		this.status=dados.status();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;
	private String descricao;
	private LocalDateTime dataHora;
	private String status;
}
