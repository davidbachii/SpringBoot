package com.example.cursospringboot.entity;

import jakarta.persistence.*;

import java.util.List;

@MappedSuperclass
public abstract class Contenido {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombreContenido", nullable = false, length = 100)
    private String nombreContenido;
    @Column(name = "descripcion", length = 1000, nullable = false)
    private String descripcion;
    @Column(name = "anho", length = 5, nullable = false)
    private Integer anho;
    @Column(name = "url_image", length = 100, nullable = false)
    private String url_image;
    @Column(name = "url_video", length = 100, nullable = false)
    private String url_video;
   // @OneToMany(mappedBy = "contenido", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Comentario> comentarios;

    //Constructor
    public Contenido() {
    }


    //Constructor con parametros
    public Contenido(String nombreContenido, String descripcion, Integer anho, String url_image, String url_video) {
        this.nombreContenido = nombreContenido;
        this.descripcion = descripcion;
        this.anho = anho;
        this.url_image = url_image;
        this.url_video = url_video;
    }

    //Getters y Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreContenido() {
        return nombreContenido;
    }
    public void setNombreContenido(String nombreContenido) {
        this.nombreContenido = nombreContenido;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getAnho() {
        return anho;
    }
    public void setAnho(Integer anho) {
        this.anho = anho;
    }
    public String getUrl_image() {
        return url_image;
    }
    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
    public String getUrl_video() {
        return url_video;
    }
    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }

}
