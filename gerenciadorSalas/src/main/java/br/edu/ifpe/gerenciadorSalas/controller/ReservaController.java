package br.edu.ifpe.gerenciadorSalas.controller;

import br.edu.ifpe.gerenciadorSalas.model.Reserva;
import br.edu.ifpe.gerenciadorSalas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.save(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reservaDetails) {
        return reservaService.findById(id)
                .map(reserva -> {
                    reserva.setSala(reservaDetails.getSala());
                    reserva.setDataInicio(reservaDetails.getDataInicio());
                    reserva.setDataFim(reservaDetails.getDataFim());
                    reserva.setServidor(reservaDetails.getServidor());
                    return ResponseEntity.ok(reservaService.save(reserva));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReserva(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(reserva -> {
                    reservaService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
