package com.example.vitaplan.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recomendaciones")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(nullable = false)
    private LocalDateTime fechaGeneracion;

    @Column(length = 50)
    private String origen; // Ej: SYSTEM, AI_VOICE, MANUAL

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Recomendacion() {
    }

    public Recomendacion(Long id, String mensaje, LocalDateTime fechaGeneracion, String origen, Usuario usuario) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaGeneracion = fechaGeneracion;
        this.origen = origen;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}