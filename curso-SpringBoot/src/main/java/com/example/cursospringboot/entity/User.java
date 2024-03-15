package com.example.cursospringboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Usuario")
public class User {

    @Id
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "nickname", length = 50, nullable = false)
    private String nickname;

    @Column(name = "contrasenha", length = 50, nullable = false)
    private String contrasenha;

    @Column(name = "fechaNacimiento", length = 12, nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "planSuscripcion", length = 20, nullable = false)
    private String planSuscripcion;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TarjetaCredito> tarjetas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;


    //Set de comentarios que ha hecho el usuario en la aplicacion

    /*
    @OneToMany(mappedBy = "usuario")
    @JsonBackReference // Esta anotación indica que este lado de la relación no debe ser serializado
    private Set<Comentario> comentarios;

     */


   //Constructor
   public User() {
   }

    //Constructor con parametros
    public User(String email, String nombre, String nickname, String contrasenha, LocalDate fechaNacimiento, String planSuscripcion) {
        this.email = email;
        this.nombre = nombre;
        this.nickname = nickname;
        this.contrasenha = contrasenha;
        this.fechaNacimiento = fechaNacimiento;
        this.planSuscripcion = planSuscripcion;
    }

    //Getters y Setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }




    public String getPlanSuscripcion() {
        return planSuscripcion;
    }

    public void setPlanSuscripcion(String planSuscripcion) {
        this.planSuscripcion = planSuscripcion;
    }


    public List<TarjetaCredito> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<TarjetaCredito> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }



}
