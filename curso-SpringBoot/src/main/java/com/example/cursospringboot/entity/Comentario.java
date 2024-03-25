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

    @Column(name = "tipo_Comentario", length = 18, nullable = false)
    private String tipoComentario;



    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email",  nullable = false)
    private User usuario;





    //Constructor
    public Comentario() {
    }

    //Constructor con parametros


    // getters and setters


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

    public String getTipoComentario() {
        return tipoComentario;
    }

    public void setTipoComentario(String tipoComentario) {
        this.tipoComentario = tipoComentario;
    }




}