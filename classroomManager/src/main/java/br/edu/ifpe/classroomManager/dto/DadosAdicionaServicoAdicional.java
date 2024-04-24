package br.edu.ifpe.classroomManager.dto;

public record DadosAdicionaServicoAdicional(
		String tipo,
		int quantidade,
		String status,
		double custo
		) {
}
