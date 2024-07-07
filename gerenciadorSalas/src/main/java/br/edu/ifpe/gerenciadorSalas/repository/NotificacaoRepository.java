package br.edu.ifpe.gerenciadorSalas.repository;

import br.edu.ifpe.gerenciadorSalas.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long>{
}
