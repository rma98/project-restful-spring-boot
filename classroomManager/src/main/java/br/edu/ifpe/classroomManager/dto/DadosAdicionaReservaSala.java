package br.edu.ifpe.classroomManager.dto;

import java.time.LocalDateTime;

public record DadosAdicionaReservaSala(
		String titulo, 
		String descricao, 
		LocalDateTime dataHora, 
		String status) {
}
