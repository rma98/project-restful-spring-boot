package br.edu.ifpe.gerenciadorSalas.repository;

import br.edu.ifpe.gerenciadorSalas.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {
    Optional<Servidor> findByEmail(String email);
    boolean existsByEmail(String email); // Adicione esta linha
}
