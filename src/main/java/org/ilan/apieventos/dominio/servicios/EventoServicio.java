package org.ilan.apieventos.dominio.servicios;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Evento;
import org.ilan.apieventos.dominio.repositorios.EventoRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventoServicio {

    private final EventoRepositorio eventoRepository;

    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Optional<Evento> obtenerEventoPorId(Long eventoId) {
        return eventoRepository.findById(eventoId);
    }

    public List<Evento> obtenerTodosEventos() {
        return eventoRepository.findAll();
    }

    public Page<Evento> obtenerEventosConPaginacion(int pagina, int tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio);
        return eventoRepository.findAll(pageable);
    }

    public void eliminarEvento(Long eventoId) {
        eventoRepository.deleteById(eventoId);
    }

    public Evento actualizarEvento(Evento evento) {
        if (eventoRepository.existsById(evento.getEventoId())) {
            return eventoRepository.save(evento);
        } else {
            throw new IllegalArgumentException("Evento no existe");
        }
    }
}