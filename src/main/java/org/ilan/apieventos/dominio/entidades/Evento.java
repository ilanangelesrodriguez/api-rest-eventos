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
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoId;

    private String nombreEvento;
    private String descripcion;
    private LocalDateTime fechaEvento;
    private String ubicacion;
    private Integer capacidad;

    @ManyToOne
    private Categoria categoria;
}
