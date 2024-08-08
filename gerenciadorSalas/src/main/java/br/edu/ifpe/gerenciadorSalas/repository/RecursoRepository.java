package br.edu.ifpe.gerenciadorSalas.repository;

import br.edu.ifpe.gerenciadorSalas.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
}
