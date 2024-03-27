package com.example.cursospringboot.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ComentarioPelicula")
public class ComentarioPelicula extends Comentario {



    @Column(name = "valoracion", nullable = false)
    private Short valoracion;

    @ManyToOne
    @JoinColumn(name = "pelicula_id", referencedColumnName = "id", nullable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email",  nullable = false)
    private User usuario;


    //Constructor
    public ComentarioPelicula() {
    }

    //Constructor con parametros
    public ComentarioPelicula(String texto, LocalDate fechaComentario, String nickname, Short valoracion, Pelicula pelicula, User usuario) {
        super(texto, fechaComentario, nickname);
        this.valoracion = valoracion;
        this.pelicula = pelicula;
        this.usuario = usuario;
    }

    //Getters y Setters

    public Short getValoracion() {
        return valoracion;
    }

    public void setValoracion(Short valoracion) {
        this.valoracion = valoracion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }


}
