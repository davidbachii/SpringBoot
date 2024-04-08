package com.example.cursospringboot.repository;

import com.example.cursospringboot.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    /*
    Lo que buscamos es que jpa haga la busqueda por nosotros y no tener que hacerlo manualmente
    Para eso usamos jpa repository que es una interfaz que nos permite hacer consultas a la base de datos
    */

    /**
     * Busca una película por su nombre de contenido.
     *
     * @param nombreContenido El nombre del contenido de la película a buscar.
     * @return Un Optional que contiene la película si se encuentra, o vacío si no se encuentra.
     */
    Optional<Pelicula> findByNombreContenido(String nombreContenido);


    /**
     * Busca películas cuyos nombres de contenido comiencen con una determinada cadena.
     *
     * @param query La cadena con la que deben comenzar los nombres de contenido de las películas.
     * @return Una lista de películas cuyos nombres de contenido comienzan con la cadena proporcionada.
     */
    List<Pelicula> findByNombreContenidoStartingWith(String query);
}
