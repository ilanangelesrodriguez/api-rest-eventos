package org.ilan.apieventos.dominio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inscripcionId;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Evento evento;

    private LocalDateTime fechaInscripcion;
    private Boolean asistencia;
}
