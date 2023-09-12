package com.unvest.usuario_ms.controllers;

import com.unvest.usuario_ms.entities.UsuarioUNvest;
import com.unvest.usuario_ms.services.UsuarioUNvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioUNvestController {
    @Autowired
    private UsuarioUNvestService usuarioUNvestService;

    @GetMapping
    public ResponseEntity<List<UsuarioUNvest>> listarUsuarios() {
        List<UsuarioUNvest> usuariosUNvest = usuarioUNvestService.getAllUsuarios();
        if (usuariosUNvest.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usuariosUNvest);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioUNvest> obtenerUsuario(@PathVariable("id") Long id) {
        UsuarioUNvest usuarioUNvest = usuarioUNvestService.getUsuarioById(id);
        if (usuarioUNvest == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuarioUNvest);
    }

    @PostMapping
    public ResponseEntity<UsuarioUNvest> guardarUsuario(@RequestBody UsuarioUNvest usuarioUNvest) {
        UsuarioUNvest newUsuarioUNvest = usuarioUNvestService.createUsuario(usuarioUNvest);
        return ResponseEntity.ok(newUsuarioUNvest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioUNvest> updateUsuario(@PathVariable Long id, @RequestBody UsuarioUNvest usuarioUNvest) {
        UsuarioUNvest usuarioUNvest1 = usuarioUNvestService.updateUsuario(id, usuarioUNvest);
        if (usuarioUNvest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioUNvest);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioUNvestService.deleteUsuario(id);
    }
}
