package br.edu.ifpe.classroomManager.controller;

import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.classroomManager.dto.DadosAdicionaReservaSala;
import br.edu.ifpe.classroomManager.model.ReservaSala;
import br.edu.ifpe.classroomManager.repository.ReservaSalaRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/reservasSalas")
public class ReservaSalaController {
	
	@Autowired
	private ReservaSalaRepository reservaSalaRepository;
	
	@PostMapping
	public void adicionar(@RequestBody DadosAdicionaReservaSala dados) {
		reservaSalaRepository.save(new ReservaSala(dados));
	}
	
}
