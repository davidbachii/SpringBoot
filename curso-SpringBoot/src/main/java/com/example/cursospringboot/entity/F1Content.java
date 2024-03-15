package com.example.cursospringboot.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "F1Content")
public class F1Content extends Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Column(name = "otrosDatos", length = 150, nullable = false)
    private String otrosDatos;

    @Column(name = "pilotos", length = 200, nullable = false)
    private String pilotos;




    //Constructor
    public F1Content() {
    }

    //Constructor con parametros
    public F1Content(String nombreContenido, String descripcion, String tipo, Integer anho, String url_image, String url_video, String paginaOficial, String circuito, String equipos, String nacionalidad, Integer duracion, String otrosDatos, String pilotos) {
        super(nombreContenido, descripcion, tipo, anho, url_image, url_video);
        this.paginaOficial = paginaOficial;
        this.circuito = circuito;
        this.equipos = equipos;
        this.nacionalidad = nacionalidad;
        this.duracion = duracion;
        this.otrosDatos = otrosDatos;
        this.pilotos = pilotos;
    }

    //Getters y Setters
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
}
