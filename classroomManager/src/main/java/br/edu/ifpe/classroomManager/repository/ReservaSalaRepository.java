package br.edu.ifpe.classroomManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpe.classroomManager.model.ReservaSala;

@Repository
public interface ReservaSalaRepository extends JpaRepository<ReservaSala, Long>{
}
