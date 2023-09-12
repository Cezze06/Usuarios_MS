package com.unvest.usuario_ms.entities;

import jakarta.persistence.*;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Long id_perfil;
    private String nombre_perfil;
    private String apellido_perfil;
    private String correo_perfil;
    private String telefono_perfil;
    private String imagen_perfil;
    @OneToOne
    @JoinColumn(name = "id")  // Referencia a la columna id del 'padre' UsuarioUNvest
    private UsuarioUNvest usuarioUNvest;

    // Constructors

    public Perfil() {
    }

    public Perfil(Long id_perfil, String nombre_perfil, String apellido_perfil, String correo_perfil, String telefono_perfil, String imagen_perfil, UsuarioUNvest usuarioUNvest) {
        this.id_perfil = id_perfil;
        this.nombre_perfil = nombre_perfil;
        this.apellido_perfil = apellido_perfil;
        this.correo_perfil = correo_perfil;
        this.telefono_perfil = telefono_perfil;
        this.imagen_perfil = imagen_perfil;
    }

    // Getters & Setters

    public Long getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Long id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombre_perfil() {
        return nombre_perfil;
    }

    public void setNombre_perfil(String nombre_perfil) {
        this.nombre_perfil = nombre_perfil;
    }

    public String getApellido_perfil() {
        return apellido_perfil;
    }

    public void setApellido_perfil(String apellido_perfil) {
        this.apellido_perfil = apellido_perfil;
    }

    public String getCorreo_perfil() {
        return correo_perfil;
    }

    public void setCorreo_perfil(String correo_perfil) {
        this.correo_perfil = correo_perfil;
    }

    public String getTelefono_perfil() {
        return telefono_perfil;
    }

    public void setTelefono_perfil(String telefono_perfil) {
        this.telefono_perfil = telefono_perfil;
    }

    public String getImagen_perfil() {
        return imagen_perfil;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }

    public UsuarioUNvest getUsuarioUNvest() {
        return usuarioUNvest;
    }

    public void setUsuarioUNvest(UsuarioUNvest usuarioUNvest) {
        this.usuarioUNvest = usuarioUNvest;
    }
}
