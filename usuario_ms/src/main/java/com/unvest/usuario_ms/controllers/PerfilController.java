package com.unvest.usuario_ms.controllers;

import com.unvest.usuario_ms.entities.Perfil;
import com.unvest.usuario_ms.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilController {

    @Autowired
    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }
    @GetMapping
    public ResponseEntity<List<Perfil>> getAllPerfiles() {
        List<Perfil> perfils = perfilService.getAllPerfiles();
        if (perfils.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(perfils);

        //return perfils.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfilByID(@PathVariable Long id) {
        Perfil perfilOpt = perfilService.getPerfilById(id);
        if (perfilOpt == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perfilOpt);
    }

    @PostMapping
    public ResponseEntity<Perfil> createPerfil(@RequestBody Perfil perfil) {
        Perfil perfil1 = perfilService.createPerfil(perfil);
        return ResponseEntity.ok(perfil1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> updatePerfil(@PathVariable Long id, @RequestBody Perfil perfil) {
        Perfil perfil1 = perfilService.updatePerfil(id, perfil);
        if (perfil1 == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(perfil1);
    }

    @DeleteMapping("/{id}")
    public void deletePerfilById(@PathVariable Long id) {
        perfilService.deletePerfil(id);
    }
}
