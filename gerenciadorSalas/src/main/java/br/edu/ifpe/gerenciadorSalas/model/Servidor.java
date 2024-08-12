package br.edu.ifpe.gerenciadorSalas.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.Set;

@Data
@Entity
public class Servidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha; // Campo usado para a senha
    private String tipo; // Professor, Técnico, etc.

    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL)
    private Set<Reserva> reservas;
}
