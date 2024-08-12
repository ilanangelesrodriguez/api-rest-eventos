package org.ilan.apieventos.dominio.servicios;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Inscripcion;
import org.ilan.apieventos.dominio.repositorios.InscripcionRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InscripcionServicio {

    private final InscripcionRepositorio inscripcionRepository;

    public Inscripcion crearInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public Optional<Inscripcion> obtenerInscripcionPorId(Long inscripcionId) {
        return inscripcionRepository.findById(inscripcionId);
    }

    public List<Inscripcion> obtenerTodasInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Page<Inscripcion> obtenerInscripcionesConPaginacion(int pagina, int tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio);
        return inscripcionRepository.findAll(pageable);
    }

    public void eliminarInscripcion(Long inscripcionId) {
        inscripcionRepository.deleteById(inscripcionId);
    }

    public Inscripcion actualizarInscripcion(Inscripcion inscripcion) {
        if (inscripcionRepository.existsById(inscripcion.getInscripcionId())) {
            return inscripcionRepository.save(inscripcion);
        } else {
            throw new IllegalArgumentException("Inscripción no existe");
        }
    }

}