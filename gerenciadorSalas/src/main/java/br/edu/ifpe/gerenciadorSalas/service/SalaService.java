package br.edu.ifpe.gerenciadorSalas.service;

import br.edu.ifpe.gerenciadorSalas.model.Sala;
import br.edu.ifpe.gerenciadorSalas.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository salaRepository;
	
	public List<Sala> findAll() {
        return salaRepository.findAll();
    }
	
	public Optional<Sala> findById(Long id) {
        return salaRepository.findById(id);
    }

    public Sala save(Sala sala) {
        return salaRepository.save(sala);
    }

    public void deleteById(Long id) {
        salaRepository.deleteById(id);
    }

}
