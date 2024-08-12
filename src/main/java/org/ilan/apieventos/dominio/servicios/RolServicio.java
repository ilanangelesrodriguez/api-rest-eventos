package org.ilan.apieventos.dominio.servicios;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Rol;
import org.ilan.apieventos.dominio.repositorios.RolRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolServicio {

    private final RolRepositorio rolRepository;

    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Optional<Rol> obtenerRolPorId(Long rolId) {
        return rolRepository.findById(rolId);
    }

    public List<Rol> obtenerTodosRoles() {
        return rolRepository.findAll();
    }

    public Page<Rol> obtenerRolesConPaginacion(int pagina, int tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio);
        return rolRepository.findAll(pageable);
    }

    public void eliminarRol(Long rolId) {
        rolRepository.deleteById(rolId);
    }

    public Rol actualizarRol(Rol rol) {
        if (rolRepository.existsById(rol.getRolId())) {
            return rolRepository.save(rol);
        } else {
            throw new IllegalArgumentException("Rol no existe");
        }
    }
}
