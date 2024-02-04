package com.example.cursospringboot.entity;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class User implements Serializable{

    private static final long serialVersionUID = -9069060843698080433L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(length = 50)
    private String apellido;
    @Column(length = 50, name = "mail", nullable = false, unique = true)
    private String email;
    @Column(length = 50)
    private String password;
    private Boolean enabled; // Para saber si el usuario está activo o no


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
