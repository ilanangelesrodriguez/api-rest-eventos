package org.ilan.apieventos.infraestructura.entrada.rest;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Usuario;
import org.ilan.apieventos.dominio.servicios.UsuarioServicio;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioControlador {
    private final UsuarioServicio usuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @GetMapping
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioService.obtenerTodosUsuarios();
    }

    @GetMapping("/pagina")
    public Page<Usuario> obtenerUsuariosConPaginacion(@RequestParam int pagina, @RequestParam int tamanio) {
        return usuarioService.obtenerUsuariosConPaginacion(pagina, tamanio);
    }

    @PutMapping
    public Usuario actualizarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") Long id) {
        usuarioService.eliminarUsuario(id);
    }
}

