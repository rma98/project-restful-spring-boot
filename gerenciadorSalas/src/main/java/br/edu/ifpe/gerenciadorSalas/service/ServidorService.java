package br.edu.ifpe.gerenciadorSalas.service;

import br.edu.ifpe.gerenciadorSalas.model.Servidor;
import br.edu.ifpe.gerenciadorSalas.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorService {

    @Autowired
    private ServidorRepository servidorRepository;

    public List<Servidor> findAll() {
        return servidorRepository.findAll();
    }

    public Optional<Servidor> findById(Long id) {
        return servidorRepository.findById(id);
    }

    public Servidor save(Servidor servidor) {
        return servidorRepository.save(servidor);
    }

    public void deleteById(Long id) {
        servidorRepository.deleteById(id);
    }
}
