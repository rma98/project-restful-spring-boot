package br.edu.ifpe.gerenciadorSalas.repository;

import br.edu.ifpe.gerenciadorSalas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
}
