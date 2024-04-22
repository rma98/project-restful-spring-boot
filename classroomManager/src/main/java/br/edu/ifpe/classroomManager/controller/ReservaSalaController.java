package br.edu.ifpe.classroomManager.controller;

import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.classroomManager.model.ReservaSala;
import br.edu.ifpe.classroomManager.repository.ReservaSalaRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/reservasSalas")
public class ReservaSalaController {
	
	@Autowired
	private ReservaSalaRepository reservaSalaRepository;
	
	@GetMapping	
	public List<ReservaSala> listar() {
		return reservaSalaRepository.findAll();
	}
	
	@PostMapping
	public ReservaSala adicionar(@RequestBody ReservaSala reservaSala) {
		return reservaSalaRepository.save(reservaSala);
	}
	
}
