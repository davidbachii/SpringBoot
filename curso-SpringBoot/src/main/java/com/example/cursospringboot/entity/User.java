package com.example.cursospringboot.entity;

import jakarta.persistence.*;
import java.io.Serializable;
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
    private String fechaNacimiento;

    //Set de comentarios que ha hecho el usuario en la aplicacion
    @OneToMany(mappedBy = "usuario")
    private Set<Comentario> comentarios;


   //Constructor
   public User() {
   }

    //Constructor con parametros
    public User(String email, String nombre, String apellidos, String contrasenha, String fechaNacimiento) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenha = contrasenha;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }


}
