package com.example.cursospringboot.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "F1Content")
public class F1Content extends Contenido {



    @Column(name = "circuito", length = 50, nullable = false)
    private String circuito;

    @Column(name = "equipos", length = 500, nullable = false)
    private String equipos;

    @Column(name = "nacionalidad", length = 50, nullable = false)
    private String nacionalidad;

    @Column(name = "duracion", length = 5, nullable = false)
    private Integer duracion;
    @Column(name = "otrosDatos", length = 150, nullable = false)
    private String otrosDatos;

    @Column(name = "pilotos", length = 500, nullable = false)
    private String pilotos;

    @OneToMany(mappedBy = "f1Content", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioF1> comentarios;




    //Constructor
    public F1Content() {
    }

    //Constructor con parametros
    public F1Content(String nombreContenido, String descripcion, String tipo, Integer anho, String url_image, String url_video, String circuito, String equipos, String nacionalidad, Integer duracion, String otrosDatos, String pilotos) {
        super(nombreContenido, descripcion, anho, url_image, url_video);
        this.circuito = circuito;
        this.equipos = equipos;
        this.nacionalidad = nacionalidad;
        this.duracion = duracion;
        this.otrosDatos = otrosDatos;
        this.pilotos = pilotos;
    }

    //Getters y Setters

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
