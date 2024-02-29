package com.example.cursospringboot.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "F1Content")
public class F1Content {

    @Id
    @Column(name = "nombreCarrera", nullable = false, length = 50)
    private String nombreCarrera;

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;

    @Column(name = "paginaOficial", length = 50, nullable = false)
    private String paginaOficial;

    @Column(name = "circuito", length = 50, nullable = false)
    private String circuito;

    @Column(name = "equipos", length = 50, nullable = false)
    private String equipos;

    @Column(name = "nacionalidad", length = 50, nullable = false)
    private String nacionalidad;

    @Column(name = "duracion", length = 5, nullable = false)
    private Integer duracion;

    @Column(name = "anho", length = 5, nullable = false)
    private Integer anho;

    @Column(name = "otrosDatos", length = 150, nullable = false)
    private String otrosDatos;

    @Column(name = "pilotos", length = 200, nullable = false)
    private String pilotos;

    @Column(name = "url_image", length = 100, nullable = false)
    private String url_image;

    @Column(name = "url_video", length = 100, nullable = false)
    private String url_video;

    @OneToMany(mappedBy = "f1Content", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

    //Constructor
    public F1Content() {
    }

    //Constructor con parametros
    public F1Content(String nombreCarrera, String descripcion, String paginaOficial, String circuito, String equipos, String nacionalidad, Integer duracion, Integer anho, String otrosDatos, String pilotos, String url_image, String url_video) {
        this.nombreCarrera = nombreCarrera;
        this.descripcion = descripcion;
        this.paginaOficial = paginaOficial;
        this.circuito = circuito;
        this.equipos = equipos;
        this.nacionalidad = nacionalidad;
        this.duracion = duracion;
        this.anho = anho;
        this.otrosDatos = otrosDatos;
        this.pilotos = pilotos;
        this.url_image = url_image;
        this.url_video = url_video;
    }

       //Getters y Setters

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaginaOficial() {
        return paginaOficial;
    }

    public void setPaginaOficial(String paginaOficial) {
        this.paginaOficial = paginaOficial;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getEquipos() {
        return equipos;
    }

    public void setEquipos(String equipos) {
        this.equipos = equipos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public String getOtrosDatos() {
        return otrosDatos;
    }

    public void setOtrosDatos(String otrosDatos) {
        this.otrosDatos = otrosDatos;
    }

    public String getPilotos() {
        return pilotos;
    }

    public void setPilotos(String pilotos) {
        this.pilotos = pilotos;
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
