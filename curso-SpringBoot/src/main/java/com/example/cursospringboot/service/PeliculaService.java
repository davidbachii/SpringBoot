package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PeliculaService {

    //Declaramos los metodos que vamos a usar en el servicio

    //Save nos permite guardar una pelicula en la base de datos y nos devuelve la pelicula guardado
    public Pelicula save(Pelicula pelicula);

    //FindBynombrePwlicula nos permite buscar una pelicula en la base de datos por su nombre
    public Pelicula findBynombrePelicula(String nombre);


    //Iterable es una interfaz que nos permite recorrer una lista de elementos de cualquier tipo
    public Iterable<Pelicula> findAll();

    //Page es una interfaz que nos permite paginar los resultados de una consulta a la base de datos
    public Page<Pelicula> findAll(Pageable pageable);




    //Delete nos permite eliminar una pelicula de la base de datos por su id
    public void deleteBynombrePelicula(String id);


}
