package org.ilan.apieventos.infraestructura.entrada.rest;

import org.ilan.apieventos.dominio.entidades.Evento;
import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.servicios.EventoServicio;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoControlador {
    private final EventoServicio eventoService;

    @PostMapping
    public Evento crearEvento(@RequestBody Evento evento) {
        return eventoService.crearEvento(evento);
    }

    @GetMapping("/{id}")
    public Optional<Evento> obtenerEventoPorId(@PathVariable("id") Long id) {
        return eventoService.obtenerEventoPorId(id);
    }

    @GetMapping
    public List<Evento> obtenerTodosEventos() {
        return eventoService.obtenerTodosEventos();
    }

    @GetMapping("/pagina")
    public Page<Evento> obtenerEventosConPaginacion(@RequestParam int pagina, @RequestParam int tamanio) {
        return eventoService.obtenerEventosConPaginacion(pagina, tamanio);
    }

    @PutMapping
    public Evento actualizarEvento(@RequestBody Evento evento) {
        return eventoService.actualizarEvento(evento);
    }

    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable("id") Long id) {
        eventoService.eliminarEvento(id);
    }
}