package org.ilan.apieventos.infraestructura.entrada.rest;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Admin;
import org.ilan.apieventos.dominio.servicios.AdminServicio;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminControlador {
    private final AdminServicio adminService;

    @PostMapping
    public Admin crearAdmin(@RequestBody Admin admin) {
        return adminService.crearAdmin(admin);
    }

    @GetMapping("/{id}")
    public Optional<Admin> obtenerAdminPorId(@PathVariable("id") Long id) {
        return adminService.obtenerAdminPorId(id);
    }

    @GetMapping
    public List<Admin> obtenerTodosAdmins() {
        return adminService.obtenerTodosAdmins();
    }

    @GetMapping("/pagina")
    public Page<Admin> obtenerAdminsConPaginacion(@RequestParam int pagina, @RequestParam int tamanio) {
        return adminService.obtenerAdminsConPaginacion(pagina, tamanio);
    }

    @PutMapping
    public Admin actualizarAdmin(@RequestBody Admin admin) {
        return adminService.actualizarAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void eliminarAdmin(@PathVariable("id") Long id) {
        adminService.eliminarAdmin(id);
    }
}
