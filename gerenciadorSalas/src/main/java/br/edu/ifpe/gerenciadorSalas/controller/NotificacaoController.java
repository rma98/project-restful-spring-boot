package br.edu.ifpe.gerenciadorSalas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpe.gerenciadorSalas.model.Notificacao;
import br.edu.ifpe.gerenciadorSalas.service.NotificacaoService;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

	@Autowired
	public NotificacaoService notificacaoService;
	
	@GetMapping
	public List<Notificacao> getAllNotificacoes() {
        return notificacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> getNotificacaoById(@PathVariable Long id) {
        return notificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Notificacao createNotificacao(@RequestBody Notificacao notificacao) {
        return notificacaoService.save(notificacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> updateNotificacao(@PathVariable Long id, @RequestBody Notificacao notificacaoDetails) {
        return notificacaoService.findById(id)
                .map(notificacao -> {
                    notificacao.setMensagem(notificacaoDetails.getMensagem());
                    notificacao.setDataHora(notificacaoDetails.getDataHora());
                    return ResponseEntity.ok(notificacaoService.save(notificacao));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNotificacao(@PathVariable Long id) {
        return notificacaoService.findById(id)
                .map(notificacao -> {
                    notificacaoService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
