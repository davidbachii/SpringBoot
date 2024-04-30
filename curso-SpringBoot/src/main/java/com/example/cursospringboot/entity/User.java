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

    @Column(name = "apellidos", length = 80, nullable = false)
    private String apellidos;

    @Column(name = "nickname", length = 50, nullable = false)
    private String nickname;

    @Column(name = "contrasenha", length = 50, nullable = false)
    private String contrasenha;

    @Column(name = "fechaNacimiento", length = 12, nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "planSuscripcion", length = 20, nullable = false)
    private String planSuscripcion;


    @Column(name = "pagoValidado", nullable = false)
    private Boolean pagoValidado;


    @Column(name = "url_image_perfil", length = 200)
    private String url_image_perfil;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TarjetaCredito> tarjetas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioPelicula> comentarios;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatCommunity> createdCommunities;

    @OneToMany(mappedBy = "sentBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatMessage> sentMessages;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    //Constructor
    public User() {
    }

    //Constructor con parametros
    public User(String email, String nombre, String nickname, String contrasenha, LocalDate fechaNacimiento, String planSuscripcion, String apellidos, Boolean pagoValidado, String url_image_perfil) {
        this.email = email;
        this.nombre = nombre;
        this.nickname = nickname;
        this.contrasenha = contrasenha;
        this.fechaNacimiento = fechaNacimiento;
        this.planSuscripcion = planSuscripcion;
        this.apellidos = apellidos;
        this.pagoValidado = pagoValidado;
        this.url_image_perfil = url_image_perfil;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<TarjetaCredito> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<TarjetaCredito> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public List<ComentarioPelicula> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioPelicula> comentarios) {
        this.comentarios = comentarios;
    }

    public List<ChatCommunity> getCreatedCommunities() {
        return createdCommunities;
    }

    public void setCreatedCommunities(List<ChatCommunity> createdCommunities) {
        this.createdCommunities = createdCommunities;
    }

    public List<ChatMessage> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<ChatMessage> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public Boolean getPagoValidado() {
        return pagoValidado;
    }

    public void setPagoValidado(Boolean pagoValidado) {
        this.pagoValidado = pagoValidado;
    }

    public String getUrl_image_perfil() {
        return url_image_perfil;
    }

    public void setUrl_image_perfil(String url_image_perfil) {
        this.url_image_perfil = url_image_perfil;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



}
