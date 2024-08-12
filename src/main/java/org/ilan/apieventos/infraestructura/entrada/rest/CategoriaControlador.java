package org.ilan.apieventos.infraestructura.entrada.rest;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Categoria;
import org.ilan.apieventos.dominio.servicios.CategoriaServicio;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaControlador {
    private final CategoriaServicio categoriaService;

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.crearCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Optional<Categoria> obtenerCategoriaPorId(@PathVariable("id") Long id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    @GetMapping
    public List<Categoria> obtenerTodasCategorias() {
        return categoriaService.obtenerTodasCategorias();
    }

    @GetMapping("/pagina")
    public Page<Categoria> obtenerCategoriasConPaginacion(@RequestParam int pagina, @RequestParam int tamanio) {
        return categoriaService.obtenerCategoriasConPaginacion(pagina, tamanio);
    }

    @PutMapping
    public Categoria actualizarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.actualizarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable("id") Long id) {
        categoriaService.eliminarCategoria(id);
    }
}
