package com.unvest.usuario_ms.services;

import com.unvest.usuario_ms.entities.UsuarioUNvest;
import com.unvest.usuario_ms.repositories.UsuarioUNvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUNvestService {

    @Autowired
    private final UsuarioUNvestRepository usuarioUNvestRepository;

    public UsuarioUNvestService(UsuarioUNvestRepository usuarioUNvestRepository) {
        this.usuarioUNvestRepository = usuarioUNvestRepository;
    }

    public List<UsuarioUNvest> getAllUsuarios() {
        return usuarioUNvestRepository.findAll();
    }

    public UsuarioUNvest getUsuarioById(Long id) {
        return usuarioUNvestRepository.findById(id).orElse(null);
    }

    public UsuarioUNvest createUsuario(UsuarioUNvest usuarioUNvest) {
        UsuarioUNvest newUsuarioUNvest = usuarioUNvestRepository.save(usuarioUNvest);
        return newUsuarioUNvest;
    }

    public UsuarioUNvest updateUsuario(Long id, UsuarioUNvest usuario) {
        if (usuarioUNvestRepository.existsById(id)){
            usuario.setId(id);
            return usuarioUNvestRepository.save(usuario);
        }
        else {
            return null;
        }
    }

    public void deleteUsuario(Long id) {
        usuarioUNvestRepository.deleteById(id);
    }

}