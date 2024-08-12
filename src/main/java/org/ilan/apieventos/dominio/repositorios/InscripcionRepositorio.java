package org.ilan.apieventos.dominio.repositorios;

import org.ilan.apieventos.dominio.entidades.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepositorio extends JpaRepository<Inscripcion, Long> {
}