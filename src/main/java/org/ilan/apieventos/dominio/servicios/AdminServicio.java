package org.ilan.apieventos.dominio.servicios;

import lombok.RequiredArgsConstructor;
import org.ilan.apieventos.dominio.entidades.Admin;
import org.ilan.apieventos.dominio.repositorios.AdminRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServicio {

    private final AdminRepositorio adminRepository;

    public Admin crearAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> obtenerAdminPorId(Long adminId) {
        return adminRepository.findById(adminId);
    }

    public List<Admin> obtenerTodosAdmins() {
        return adminRepository.findAll();
    }

    public Page<Admin> obtenerAdminsConPaginacion(int pagina, int tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio);
        return adminRepository.findAll(pageable);
    }

    public void eliminarAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    public Admin actualizarAdmin(Admin admin) {
        if (adminRepository.existsById(admin.getAdminId())) {
            return adminRepository.save(admin);
        } else {
            throw new IllegalArgumentException("Admin no existe");
        }
    }
}