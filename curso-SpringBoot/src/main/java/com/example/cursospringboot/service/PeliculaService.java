package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {

    //Declaramos los metodos que vamos a usar en el servicio


    //Metodo para obtener todas las peliculas
    List<Pelicula> getAllPeliculas();

    //Metodo para obtener una pelicula por su nombre
    Optional<Pelicula> getPeliculaByNombre(String nombrePelicula);
    //Metodo para guardar una pelicula
    Pelicula createPelicula(Pelicula pelicula);
    //Metodo para actualizar una pelicula
    Pelicula updatePelicula(String nombrePelicula, Pelicula detallesPelicula);
    //Metodo para eliminar una pelicula
    void deletePelicula(String nombrePelicula);


}
