package com.example.cursospringboot.entity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Pelicula")
public class Pelicula{



        @Id
        @Column(name = "nombrePelicula", nullable = false, length = 50)
        private String nombrePelicula;

        @Column(name = "sinopsis", length = 500, nullable = false)
        private String sinopsis;

        @Column(name = "paginaOficial", length = 50, nullable = false)
        private String paginaOficial;

        @Column(name = "tituloOriginal", length = 50, nullable = false)
        private String tituloOriginal;

        @Column(name = "genero", length = 50, nullable = false)
        private String genero;

        @Column(name = "nacionalidad", length = 50, nullable = false)
        private String nacionalidad;

        @Column(name = "duracion", length = 5, nullable = false)
        private Integer duracion;

        @Column(name = "anho", length = 5, nullable = false)
        private Integer anho;

        @Column(name = "distribuidora", length = 50, nullable = false)
        private String distribuidora;

        @Column(name = "director", length = 50, nullable = false)
        private String director;

        @Column(name = "clasificacionEdad", length = 3, nullable = false)
        private Short clasificacionEdad;

        @Column(name = "otrosDatos", length = 150, nullable = false)
        private String otrosDatos;

        @Column(name = "actores", length = 100, nullable = false)
        private String actores;

        @Column(name = "url_image", length = 50, nullable = false)
        private String url_image;

        @Column(name = "url_video", length = 50, nullable = false)
        private String url_video;

        @OneToMany(mappedBy = "pelicula")
        private Set<Comentario> comentarios;

        //Constructor
        public Pelicula() {
        }

        //Constructor con parametros

        public Pelicula(String nombrePelicula, String sinopsis, String paginaOficial, String tituloOriginal, String genero, String nacionalidad, Integer duracion, Integer anho, String distribuidora, String director, Short clasificacionEdad, String otrosDatos, String actores, String url_image, String url_video) {
            this.nombrePelicula = nombrePelicula;
            this.sinopsis = sinopsis;
            this.paginaOficial = paginaOficial;
            this.tituloOriginal = tituloOriginal;
            this.genero = genero;
            this.nacionalidad = nacionalidad;
            this.duracion = duracion;
            this.anho = anho;
            this.distribuidora = distribuidora;
            this.director = director;
            this.clasificacionEdad = clasificacionEdad;
            this.otrosDatos = otrosDatos;
            this.actores = actores;
            this.url_image = url_image;
            this.url_video = url_video;

        }





        //Getters and Setters


        public String getNombrePelicula() {
            return nombrePelicula;
        }

        public void setNombrePelicula(String nombrePelicula) {
            this.nombrePelicula = nombrePelicula;
        }

        public String getSinopsis() {
            return sinopsis;
        }

        public void setSinopsis(String sinopsis) {
            this.sinopsis = sinopsis;
        }

        public String getPaginaOficial() {
            return paginaOficial;
        }

        public void setPaginaOficial(String paginaOficial) {
            this.paginaOficial = paginaOficial;
        }

        public String getTituloOriginal() {
            return tituloOriginal;
        }

        public void setTituloOriginal(String tituloOriginal) {
            this.tituloOriginal = tituloOriginal;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getNacionalidad() {
            return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }

        public Integer getDuracion() {
            return duracion;
        }

        public void setDuracion(Integer duracion) {
            this.duracion = duracion;
        }

        public Integer getAnho() {
            return anho;
        }

        public void setAnho(Integer anho) {
            this.anho = anho;
        }

        public String getDistribuidora() {
            return distribuidora;
        }

        public void setDistribuidora(String distribuidora) {
            this.distribuidora = distribuidora;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public Short getClasificacionEdad() {
            return clasificacionEdad;
        }

        public void setClasificacionEdad(Short clasificacionEdad) {
            this.clasificacionEdad = clasificacionEdad;
        }

        public String getOtrosDatos() {
            return otrosDatos;
        }

        public void setOtrosDatos(String otrosDatos) {
            this.otrosDatos = otrosDatos;
        }

        public String getActores() {
            return actores;
        }

        public void setActores(String actores) {
            this.actores = actores;
        }

        public String getUrl_image() {
            return url_image;
        }

        public void setUrl_image(String url_image) {
            this.url_image = url_image;
        }

        public String getUrl_video() {
            return url_video;
        }

        public void setUrl_video(String url_video) {
            this.url_video = url_video;
        }

        public Set<Comentario> getComentarios() {
            return comentarios;
        }

        public void setComentarios(Set<Comentario> comentarios) {
            this.comentarios = comentarios;
        }

}
