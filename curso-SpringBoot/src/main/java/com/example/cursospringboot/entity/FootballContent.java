package com.example.cursospringboot.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "FootballContent")
public class FootballContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombrePartido", nullable = false, length = 50)
    private String nombrePartido;

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;

    @Column(name = "paginaOficial", length = 50, nullable = false)
    private String paginaOficial;

    @Column(name = "estadio", length = 50, nullable = false)
    private String estadio;

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

    @Column(name = "jugadores", length = 200, nullable = false)
    private String jugadores;

    @Column(name = "url_image", length = 100, nullable = false)
    private String url_image;

    @Column(name = "url_video", length = 100, nullable = false)
    private String url_video;

    @OneToMany(mappedBy = "footballContent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

    //Constructor
    public FootballContent() {
    }

    //Constructor con parametros
    public FootballContent(String nombrePartido, String descripcion, String paginaOficial, String estadio, String equipos, String nacionalidad, Integer duracion, Integer anho, String otrosDatos, String jugadores, String url_image, String url_video) {
        this.nombrePartido = nombrePartido;
        this.descripcion = descripcion;
        this.paginaOficial = paginaOficial;
        this.estadio = estadio;
        this.equipos = equipos;
        this.nacionalidad = nacionalidad;
        this.duracion = duracion;
        this.anho = anho;
        this.otrosDatos = otrosDatos;
        this.jugadores = jugadores;
        this.url_image = url_image;
        this.url_video = url_video;
    }

    //Getters y Setters

    public String getNombrePartido() {
        return nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
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

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
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

    public String getJugadores() {
        return jugadores;
    }

    public void setJugadores(String jugadores) {
        this.jugadores = jugadores;
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