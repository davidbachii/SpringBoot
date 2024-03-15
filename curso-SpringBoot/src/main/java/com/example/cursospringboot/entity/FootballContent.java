package com.example.cursospringboot.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "FootballContent")
public class FootballContent extends Contenido{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "estadio", length = 50, nullable = false)
    private String estadio;
    @Column(name = "equipos", length = 50, nullable = false)
    private String equipos;
    @Column(name = "nacionalidad", length = 50, nullable = false)
    private String nacionalidad;
    @Column(name = "duracion", length = 5, nullable = false)
    private Integer duracion;
    @Column(name = "otrosDatos", length = 150, nullable = false)
    private String otrosDatos;
    @Column(name = "jugadores", length = 200, nullable = false)
    private String jugadores;

    //Constructor
    public FootballContent() {
    }

    //Constructor con parametros
    public FootballContent(String nombreContenido, String descripcion, String tipo, Integer anho, String url_image, String url_video, String estadio, String equipos, String nacionalidad, Integer duracion, String otrosDatos, String jugadores) {
        super(nombreContenido, descripcion, tipo, anho, url_image, url_video);
        this.estadio = estadio;
        this.equipos = equipos;
        this.nacionalidad = nacionalidad;
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