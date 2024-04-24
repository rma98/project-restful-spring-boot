package br.edu.ifpe.classroomManager.model;

import br.edu.ifpe.classroomManager.dto.DadosAdicionaServicoAdicional;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "servico_adicional")
@Data
@Entity
public class ServicoAdicional {
	
	public ServicoAdicional(DadosAdicionaServicoAdicional dados) {
		this.tipo=dados.tipo();
		this.quantidade=dados.quantidade();
		this.status=dados.status();
		this.custo=dados.custo();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_servico_adicional;
	
	private String tipo;
	private int quantidade;
	private String status;
	private double custo;
}
