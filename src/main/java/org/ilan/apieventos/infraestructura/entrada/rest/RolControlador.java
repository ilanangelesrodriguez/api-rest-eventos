package org.ilan.apieventos.infraestructura.entrada.rest;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Rol;
import org.ilan.apieventos.dominio.servicios.RolServicio;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolControlador {
    private final RolServicio rolService;

    @PostMapping
    public Rol crearRol(@RequestBody Rol rol) {
        return rolService.crearRol(rol);
    }

    @GetMapping("/{id}")
    public Optional<Rol> obtenerRolPorId(@PathVariable("id") Long id) {
        return rolService.obtenerRolPorId(id);
    }

    @GetMapping
    public List<Rol> obtenerTodosRoles() {
        return rolService.obtenerTodosRoles();
    }

    @GetMapping("/pagina")
    public Page<Rol> obtenerRolesConPaginacion(@RequestParam int pagina, @RequestParam int tamanio) {
        return rolService.obtenerRolesConPaginacion(pagina, tamanio);
    }

    @PutMapping
    public Rol actualizarRol(@RequestBody Rol rol) {
        return rolService.actualizarRol(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable("id") Long id) {
        rolService.eliminarRol(id);
    }
}
