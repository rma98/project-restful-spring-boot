package br.edu.ifpe.gerenciadorSalas.repository;

import br.edu.ifpe.gerenciadorSalas.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long>{
}
