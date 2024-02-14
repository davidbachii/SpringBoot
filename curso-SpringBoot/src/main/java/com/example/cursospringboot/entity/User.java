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
public class User implements Serializable{



    @Id
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "contrasenha", length = 50, nullable = false)
    private String contrasenha;

    @Column(name = "fechaNacimiento", length = 12, nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "planSuscripcion", length = 20, nullable = false)
    private String planSuscripcion;


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
    public User(String email, String nombre, String apellidos, String contrasenha, LocalDate fechaNacimiento, String planSuscripcion) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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


}
