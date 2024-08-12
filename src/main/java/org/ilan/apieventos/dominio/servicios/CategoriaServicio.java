package org.ilan.apieventos.dominio.servicios;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Categoria;
import org.ilan.apieventos.dominio.repositorios.CategoriaRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServicio {

    private final CategoriaRepositorio categoriaRepository;

    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> obtenerCategoriaPorId(Long categoriaId) {
        return categoriaRepository.findById(categoriaId);
    }

    public List<Categoria> obtenerTodasCategorias() {
        return categoriaRepository.findAll();
    }

    public Page<Categoria> obtenerCategoriasConPaginacion(int pagina, int tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio);
        return categoriaRepository.findAll(pageable);
    }

    public void eliminarCategoria(Long categoriaId) {
        categoriaRepository.deleteById(categoriaId);
    }

    public Categoria actualizarCategoria(Categoria categoria) {
        if (categoriaRepository.existsById(categoria.getCategoriaId())) {
            return categoriaRepository.save(categoria);
        } else {
            throw new IllegalArgumentException("Categoría no existe");
        }
    }
}
