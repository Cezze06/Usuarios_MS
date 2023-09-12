package com.unvest.usuario_ms.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UsuarioUNvest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String password;

    private Boolean activo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioUNvest")
    private Perfil perfil;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioUNvest")
    private List<StockWatchlist> stockWatchlist;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioUNvest")
    private List<NewWatchlist> newWatchlist;

    // Constructor
    public UsuarioUNvest() {
    }

    public UsuarioUNvest(Long id, String nombre, String password, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.activo = activo;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<StockWatchlist> getStockWatchlist() {
        return stockWatchlist;
    }

    public void setStockWatchlist(List<StockWatchlist> stockWatchlist) {
        this.stockWatchlist = stockWatchlist;
    }

    public List<NewWatchlist> getNewWatchlist() {
        return newWatchlist;
    }

    public void setNewWatchlist(List<NewWatchlist> newWatchlist) {
        this.newWatchlist = newWatchlist;
    }
}
