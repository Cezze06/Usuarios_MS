package com.unvest.usuario_ms.services;

import com.unvest.usuario_ms.entities.Perfil;
import com.unvest.usuario_ms.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {
    @Autowired
    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public List<Perfil> getAllPerfiles() {
        return perfilRepository.findAll();
    }

    public Perfil getPerfilById(Long id) {
        return perfilRepository.findById(id).orElse(null);
    }

    public Perfil createPerfil(Perfil perfil) {
        Perfil newPerfil = perfilRepository.save(perfil);
        return newPerfil;
    }

    public Perfil updatePerfil(Long id, Perfil perfil) {
        if (perfilRepository.existsById(id)) {
            perfil.setId_perfil(id);
            return perfilRepository.save(perfil);
        }
        else {
            return null;
        }
    }

    public void deletePerfil(Long id){  perfilRepository.deleteById(id);}
}
