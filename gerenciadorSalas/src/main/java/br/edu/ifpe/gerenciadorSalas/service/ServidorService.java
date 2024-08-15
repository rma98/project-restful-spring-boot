package br.edu.ifpe.gerenciadorSalas.service;

import br.edu.ifpe.gerenciadorSalas.model.Servidor;
import br.edu.ifpe.gerenciadorSalas.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorService {

    @Autowired
    private ServidorRepository servidorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean existsByEmail(String email) {
        return servidorRepository.existsByEmail(email);
    }

    public Servidor save(Servidor servidor) {
        servidor.setSenha(passwordEncoder.encode(servidor.getSenha()));
        return servidorRepository.save(servidor);
    }

    public List<Servidor> findAll() {
        return servidorRepository.findAll();
    }

    public Optional<Servidor> findById(Long id) {
        return servidorRepository.findById(id);
    }

    public void deleteById(Long id) {
        servidorRepository.deleteById(id);
    }
}
