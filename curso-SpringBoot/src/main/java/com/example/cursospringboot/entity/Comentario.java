package com.example.cursospringboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Comentario")
public class Comentario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "texto",length = 500, nullable = false)
    private String texto;

    @Column(name = "valoracion", nullable = false)
    private Short valoracion;

    @Column(name = "fechaComentario", length = 12, nullable = false)
    private String fechaComentario;



    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email",  nullable = false)
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "nombrePelicula_Pelicula", referencedColumnName = "nombrePelicula",nullable = false)
    private Pelicula pelicula;


    @ManyToOne
    @JoinColumn(name = "liveContent_id", referencedColumnName = "id")
    private LiveContent liveContent;

    @ManyToOne
    @JoinColumn(name = "f1Content_id", referencedColumnName = "nombreCarrera")
    private F1Content f1Content;

    @ManyToOne
    @JoinColumn(name = "footballContent_id", referencedColumnName = "id")
    private FootballContent footballContent;



    //Constructor
    public Comentario() {
    }

    //Constructor con parametros
    public Comentario(String texto, Short valoracion, String fechaComentario, User usuario, Pelicula pelicula) {
        this.texto = texto;
        this.valoracion = valoracion;
        this.fechaComentario = fechaComentario;
        this.usuario = usuario;
        this.pelicula = pelicula;
    }

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Short getValoracion() {
        return valoracion;
    }

    public void setValoracion(Short valoracion) {
        this.valoracion = valoracion;
    }

    public String getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(String fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public LiveContent getLiveContent() {
        return liveContent;
    }

    public void setLiveContent(LiveContent liveContent) {
        this.liveContent = liveContent;
    }

    public F1Content getF1Content() {
        return f1Content;
    }

    public void setF1Content(F1Content f1Content) {
        this.f1Content = f1Content;
    }

    public FootballContent getFootballContent() {
        return footballContent;
    }

    public void setFootballContent(FootballContent footballContent) {
        this.footballContent = footballContent;
    }
}