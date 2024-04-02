package com.example.cursospringboot.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "FootballContent")
public class FootballContent extends Contenido{


    @Column(name = "estadio", length = 50, nullable = false)
    private String estadio;
    @Column(name = "equipos", length = 50, nullable = false)
    private String equipos;
    @Column(name = "competicion", length = 50, nullable = false)
    private String competicion;
    @Column(name = "duracion", length = 5, nullable = false)
    private Integer duracion;
    @Column(name = "otrosDatos", length = 150, nullable = false)
    private String otrosDatos;
    @Column(name = "jugadores", length = 200, nullable = false)
    private String jugadores;

    @OneToMany(mappedBy = "footballContent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioFootball> comentarios;

    //Constructor
    public FootballContent() {
    }

    //Constructor con parametros
    public FootballContent(String nombreContenido, String descripcion, Integer anho, String url_image, String url_video, String estadio, String equipos, String competicion, Integer duracion, String otrosDatos, String jugadores) {
        super(nombreContenido, descripcion, anho, url_image, url_video);
        this.estadio = estadio;
        this.equipos = equipos;
        this.competicion = competicion;
        this.duracion = duracion;
        this.otrosDatos = otrosDatos;
        this.jugadores = jugadores;
    }

    //Getters y Setters
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

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
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
}