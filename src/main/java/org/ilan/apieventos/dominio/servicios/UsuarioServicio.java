package org.ilan.apieventos.dominio.servicios;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Usuario;
import org.ilan.apieventos.dominio.repositorios.UsuarioRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServicio {

    private final UsuarioRepositorio usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Page<Usuario> obtenerUsuariosConPaginacion(int pagina, int tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio);
        return usuarioRepository.findAll(pageable);
    }

    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getUsuarioId())) {
            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("Usuario no existe");
        }
    }
}
