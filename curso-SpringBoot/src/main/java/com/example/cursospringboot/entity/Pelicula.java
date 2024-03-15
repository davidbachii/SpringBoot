package com.example.cursospringboot.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Pelicula")
public class Pelicula extends Contenido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tituloOriginal", length = 50, nullable = false)
    private String tituloOriginal;

    @Column(name = "genero", length = 50, nullable = false)
    private String genero;

    @Column(name = "nacionalidad", length = 50, nullable = false)
    private String nacionalidad;

    @Column(name = "duracion", length = 5, nullable = false)
    private Integer duracion;

    @Column(name = "anho", length = 5, nullable = false)
    private Integer anho;

    @Column(name = "distribuidora", length = 50, nullable = false)
    private String distribuidora;

    @Column(name = "director", length = 50, nullable = false)
    private String director;

    @Column(name = "clasificacionEdad", length = 3, nullable = false)
    private Short clasificacionEdad;

    @Column(name = "otrosDatos", length = 150, nullable = false)
    private String otrosDatos;

    @Column(name = "actores", length = 200, nullable = false)
    private String actores;

    @Column(name = "calificacion", length = 3, nullable = false)
    private double calificacion;


    //Constructor
    public Pelicula() {
    }

    //Constructor con parametros
    public Pelicula(String nombreContenido, String descripcion, String tipo, Integer anho, String url_image, String url_video, String tituloOriginal, String genero, String nacionalidad, Integer duracion, String distribuidora, String director, Short clasificacionEdad, String otrosDatos, String actores, double calificacion) {
        super(nombreContenido, descripcion, tipo, anho, url_image, url_video);
        this.tituloOriginal = tituloOriginal;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.duracion = duracion;
        this.distribuidora = distribuidora;
        this.director = director;
        this.clasificacionEdad = clasificacionEdad;
        this.otrosDatos = otrosDatos;
        this.actores = actores;
        this.calificacion = calificacion;
    }

    //Getters y Setters
    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    @Override
    public Integer getAnho() {
        return anho;
    }

    @Override
    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Short getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(Short clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public String getOtrosDatos() {
        return otrosDatos;
    }

    public void setOtrosDatos(String otrosDatos) {
        this.otrosDatos = otrosDatos;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
