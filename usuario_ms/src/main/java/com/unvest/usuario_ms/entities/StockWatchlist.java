package com.unvest.usuario_ms.entities;

import jakarta.persistence.*;

@Entity
public class StockWatchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_stock;

    @ManyToOne
    @JoinColumn(name = "id")  // Referencia a la columna id del 'padre' UsuarioUNvest
    private UsuarioUNvest usuarioUNvest;

    // Constructors

    public StockWatchlist() {
    }

    public StockWatchlist(Long id_stock) {
        this.id_stock = id_stock;
    }

    // Getters & Setters

    public Long getId_stock() {
        return id_stock;
    }

    public void setId_stock(Long id_stock) {
        this.id_stock = id_stock;
    }

    public UsuarioUNvest getUsuarioUNvest() {
        return usuarioUNvest;
    }

    public void setUsuarioUNvest(UsuarioUNvest usuarioUNvest) {
        this.usuarioUNvest = usuarioUNvest;
    }
}
