package com.example.cursospringboot.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ChatCommunity")
public class ChatCommunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nombreComunidad",length = 30, nullable = false)
    private String nombreComunidad;
    @Column(name = "descripcion", length = 1000, nullable = false)
    private String descripcion;
    @Column(name = "fechaCreacion", length = 12, nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "url_image", length = 100, nullable = false)
    private String url_image;

    @ManyToOne
    private User createdBy;


    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatMessage> messages;

    //Constructor
    public ChatCommunity() {
    }

    //Constructor con parametros
    public ChatCommunity(String nombreComunidad, String descripcion, LocalDate fechaCreacion, User createdBy, String url_image) {
        this.nombreComunidad = nombreComunidad;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDate.now();;
        this.createdBy = createdBy;
        this.url_image = url_image;
    }

    //Getters y Setters


    public String getNombreComunidad() {
        return nombreComunidad;
    }

    public void setNombreComunidad(String nombreComunidad) {
        this.nombreComunidad = nombreComunidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = LocalDate.now();
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
}
