package br.edu.ifpe.gerenciadorSalas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpe.gerenciadorSalas.model.Recurso;
import br.edu.ifpe.gerenciadorSalas.repository.RecursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

	@Autowired
	private RecursoRepository recursoRepository;
	
	public List<Recurso> findAll() {
        return recursoRepository.findAll();
    }

    public Optional<Recurso> findById(Long id) {
        return recursoRepository.findById(id);
    }

    public Recurso save(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    public void deleteById(Long id) {
        recursoRepository.deleteById(id);
    }
}
