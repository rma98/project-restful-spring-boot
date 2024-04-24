package br.edu.ifpe.classroomManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.classroomManager.dto.DadosAdicionaServicoAdicional;
import br.edu.ifpe.classroomManager.model.ServicoAdicional;
import br.edu.ifpe.classroomManager.repository.ServicoAdicionalRepository;

@RestController
@RequestMapping("/servicoAdicional")
public class ServicoAdicionalController {

	@Autowired
	private ServicoAdicionalRepository servicoAdicionalRepository;
	
	@PostMapping
	public void adicionar(@RequestBody DadosAdicionaServicoAdicional dados) {
		servicoAdicionalRepository.save(new ServicoAdicional(dados));
	}
}
