package org.ilan.apieventos.dominio.repositorios;

import org.ilan.apieventos.dominio.entidades.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositorio extends JpaRepository<Admin, Long> {
}

