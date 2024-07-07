package br.edu.ifpe.gerenciadorSalas.service;


import br.edu.ifpe.gerenciadorSalas.model.Notificacao;
import br.edu.ifpe.gerenciadorSalas.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

	@Autowired
	private NotificacaoRepository notificacaoRepository;
	
	public List<Notificacao> findAll() {
        return notificacaoRepository.findAll();
    }
	
	public Optional<Notificacao> findById(Long id) {
        return notificacaoRepository.findById(id);
	}
	
	public Notificacao save(Notificacao notificacao) {
	    return notificacaoRepository.save(notificacao);
	}

	public void deleteById(Long id) {
	    notificacaoRepository.deleteById(id);
	}
}
