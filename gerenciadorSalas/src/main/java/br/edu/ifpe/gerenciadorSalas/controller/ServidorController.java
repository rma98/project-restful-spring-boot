package br.edu.ifpe.gerenciadorSalas.controller;

import br.edu.ifpe.gerenciadorSalas.model.Servidor;
import br.edu.ifpe.gerenciadorSalas.service.ServidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servidores")
public class ServidorController {

    @Autowired
    private ServidorService servidorService;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody Servidor servidor) {
        try {
            // Certifique-se de que o e-mail é único
            if (servidorService.existsByEmail(servidor.getEmail())) {
                return ResponseEntity.badRequest().body("E-mail já em uso");
            }
            
            // Salva o novo usuário
            Servidor savedServidor = servidorService.save(servidor);
            return ResponseEntity.ok(savedServidor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar o usuário");
        }
    }

    @GetMapping
    public List<Servidor> getAllServidores() {
        return servidorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servidor> getServidorById(@PathVariable Long id) {
        return servidorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servidor> updateServidor(@PathVariable Long id, @RequestBody Servidor servidorDetails) {
        return servidorService.findById(id)
                .map(servidor -> {
                    servidor.setNome(servidorDetails.getNome());
                    servidor.setEmail(servidorDetails.getEmail());
                    servidor.setTipo(servidorDetails.getTipo());
                    return ResponseEntity.ok(servidorService.save(servidor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteServidor(@PathVariable Long id) {
        return servidorService.findById(id)
                .map(servidor -> {
                    servidorService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
