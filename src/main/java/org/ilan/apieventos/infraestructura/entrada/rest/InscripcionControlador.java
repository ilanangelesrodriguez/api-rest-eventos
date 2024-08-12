package org.ilan.apieventos.infraestructura.entrada.rest;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Inscripcion;
import org.ilan.apieventos.dominio.servicios.InscripcionServicio;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscripciones")
@RequiredArgsConstructor
public class InscripcionControlador {
    private final InscripcionServicio inscripcionService;

    @PostMapping
    public Inscripcion crearInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.crearInscripcion(inscripcion);
    }

    @GetMapping("/{id}")
    public Optional<Inscripcion> obtenerInscripcionPorId(@PathVariable("id") Long id) {
        return inscripcionService.obtenerInscripcionPorId(id);
    }

    @GetMapping
    public List<Inscripcion> obtenerTodasInscripciones() {
        return inscripcionService.obtenerTodasInscripciones();
    }

    @GetMapping("/pagina")
    public Page<Inscripcion> obtenerInscripcionesConPaginacion(@RequestParam int pagina, @RequestParam int tamanio) {
        return inscripcionService.obtenerInscripcionesConPaginacion(pagina, tamanio);
    }

    @PutMapping
    public Inscripcion actualizarInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.actualizarInscripcion(inscripcion);
    }

    @DeleteMapping("/{id}")
    public void eliminarInscripcion(@PathVariable("id") Long id) {
        inscripcionService.eliminarInscripcion(id);
    }
}
