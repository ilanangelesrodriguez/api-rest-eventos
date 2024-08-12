package org.ilan.apieventos.dominio.repositorios;

import org.ilan.apieventos.dominio.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Long> {
}
