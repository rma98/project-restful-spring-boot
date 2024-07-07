package br.edu.ifpe.gerenciadorSalas.controller;

import br.edu.ifpe.gerenciadorSalas.model.Sala;
import br.edu.ifpe.gerenciadorSalas.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping
	public List<Sala> getAllSalas() {
        return salaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable Long id) {
        return salaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sala createSala(@RequestBody Sala sala) {
        return salaService.save(sala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable Long id, @RequestBody Sala salaDetails) {
        return salaService.findById(id)
                .map(sala -> {
                    sala.setNome(salaDetails.getNome());
                    sala.setTipo(salaDetails.getTipo());
                    sala.setDisponivel(salaDetails.getDisponivel());
                    return ResponseEntity.ok(salaService.save(sala));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSala(@PathVariable Long id) {
        return salaService.findById(id)
                .map(sala -> {
                    salaService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
