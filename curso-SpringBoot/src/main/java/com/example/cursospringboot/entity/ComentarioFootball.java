package com.example.cursospringboot.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ComentarioFootball")
public class ComentarioFootball  extends Comentario{


    @ManyToOne
    @JoinColumn(name = "FootballContent_id", referencedColumnName = "id", nullable = false)
    private FootballContent footballContent;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email",  nullable = false)
    private User usuario;

    //Constructor
    public ComentarioFootball() {
    }

    //Constructor con parametros
    public ComentarioFootball(String texto, LocalDate fechaComentario, String nickname, FootballContent footballContent, User usuario) {
        super(texto, fechaComentario, nickname);
        this.footballContent = footballContent;
        this.usuario = usuario;
    }

    //Getters y Setters

    public FootballContent getFootballContent() {
        return footballContent;
    }

    public void setFootballContent(FootballContent footballContent) {
        this.footballContent = footballContent;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
