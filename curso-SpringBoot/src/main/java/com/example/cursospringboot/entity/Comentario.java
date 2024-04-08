package com.example.cursospringboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Comentario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "texto",length = 500, nullable = false)
    private String texto;

    @Column(name = "fechaComentario", length = 12, nullable = false)
    private LocalDate fechaComentario;

    @Column(name = "user_nickname", nullable = false)
    private String nickname;




    //Constructor
    public Comentario() {
    }

    //Constructor con parametros
    public Comentario(String texto, LocalDate fechaComentario, String nickname) {
        this.texto = texto;
        this.fechaComentario = fechaComentario;
        this.nickname = nickname;
    }

    //Getters y Setters
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario() {
        this.fechaComentario = LocalDate.now();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}