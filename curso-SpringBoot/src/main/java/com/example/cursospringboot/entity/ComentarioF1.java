package com.example.cursospringboot.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ComentarioF1")
public class ComentarioF1 extends Comentario{

    @ManyToOne
    @JoinColumn(name = "F1Content_id", referencedColumnName = "id", nullable = false)
    private F1Content f1Content;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email",  nullable = false)
    private User usuario;

    //Constructor
    public ComentarioF1() {
    }

    //Constructor con parametros
    public ComentarioF1(String texto, LocalDate fechaComentario, String nickname, F1Content f1Content, User usuario) {
        super(texto, fechaComentario, nickname);
        this.f1Content = f1Content;
        this.usuario = usuario;
    }

    //Getters y Setters


    public F1Content getF1Content() {
        return f1Content;
    }

    public void setF1Content(F1Content f1Content) {
        this.f1Content = f1Content;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
