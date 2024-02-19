package com.example.cursospringboot.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "TarjetaCredito")
public class TarjetaCredito {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "titular", length = 50, nullable = false)
    private String titular;

    @Column(name = "numeroT", length = 25, nullable = false)
    private String numeroT;

    @Column(name = "fechaCaducidad", length = 10, nullable = false)
    private String fechaCaducidad;

    @Column(name = "codigoSeguridad", length = 3, nullable = false)
    private String codigoSeguridad;



    //Constructor
    public TarjetaCredito() {
    }

    //Constructor con parametros
    public TarjetaCredito(String titular, String numeroT, String fechaCaducidad, String codigoSeguridad) {
        this.titular = titular;
        this.numeroT = numeroT;
        this.fechaCaducidad = fechaCaducidad;
        this.codigoSeguridad = codigoSeguridad;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroT() {
        return numeroT;
    }

    public void setNumeroT(String numeroT) {
        this.numeroT = numeroT;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
}
