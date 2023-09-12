package com.unvest.usuario_ms.entities;

import jakarta.persistence.*;

@Entity
public class NewWatchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_new;

    @ManyToOne
    @JoinColumn(name = "id")  // Referencia a la columna id del 'padre' UsuarioUNvest
    private UsuarioUNvest usuarioUNvest;


    // Constructors

    public NewWatchlist() {
    }

    public NewWatchlist(Long id_new) {
        this.id_new = id_new;
    }

    // Getters & Setters

    public Long getId_new() {
        return id_new;
    }

    public void setId_new(Long id_stock) {
        this.id_new = id_stock;
    }

    public UsuarioUNvest getUsuarioUNvest() {
        return usuarioUNvest;
    }

    public void setUsuarioUNvest(UsuarioUNvest usuarioUNvest) {
        this.usuarioUNvest = usuarioUNvest;
    }
}
