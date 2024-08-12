package org.ilan.apieventos.dominio.repositorios;

import org.ilan.apieventos.dominio.entidades.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Long> {
}
