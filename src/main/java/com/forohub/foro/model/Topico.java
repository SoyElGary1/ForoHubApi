package com.forohub.foro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDate fecha;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String curso;

    public Topico(@NotBlank String titulo, @NotBlank String mensaje, @NotBlank String curso) {
            this.titulo = titulo;
            this.mensaje = mensaje;
            this.curso = curso;
    }
}
