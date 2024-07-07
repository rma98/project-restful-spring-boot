package br.edu.ifpe.gerenciadorSalas.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
public class Sala {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String tipo; // Sala de aula ou laboratório

    private boolean disponivel;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private Set<Reserva> reservas;
    
 // Getters and setters

    @JsonProperty("disponivel")
    public String isDisponivelAsString() {
        return disponivel ? "sim" : "não";
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
