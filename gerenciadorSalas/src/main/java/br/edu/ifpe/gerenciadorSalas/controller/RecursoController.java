package br.edu.ifpe.gerenciadorSalas.controller;

import br.edu.ifpe.gerenciadorSalas.model.Recurso;
import br.edu.ifpe.gerenciadorSalas.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

	@Autowired
	private RecursoService recursoService;
	
	@GetMapping
	public List<Recurso> getAllRecursos() {
        return recursoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> getRecursoById(@PathVariable Long id) {
        return recursoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recurso createRecurso(@RequestBody Recurso recurso) {
        return recursoService.save(recurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> updateRecurso(@PathVariable Long id, @RequestBody Recurso recursoDetails) {
        return recursoService.findById(id)
                .map(recurso -> {
                    recurso.setNome(recursoDetails.getNome());
                    recurso.setDescricao(recursoDetails.getDescricao());
                    return ResponseEntity.ok(recursoService.save(recurso));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRecurso(@PathVariable Long id) {
        return recursoService.findById(id)
                .map(recurso -> {
                    recursoService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
	
}
