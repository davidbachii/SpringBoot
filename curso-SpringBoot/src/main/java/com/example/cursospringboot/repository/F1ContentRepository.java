package com.example.cursospringboot.repository;


import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface F1ContentRepository extends JpaRepository<F1Content, Long> {

    /*
    Lo que buscamos es que jpa haga la busqueda por nosotros y no tener que hacerlo manualmente
    Para eso usamos jpa repository que es una interfaz que nos permite hacer consultas a la base de datos
    */
    Optional<F1Content> findByNombreContenido(String nombreContenido);


    /**
     * Busca carreras de f1 cuyos nombres de contenido comiencen con una determinada cadena.
     *
     * @param query La cadena con la que deben comenzar los nombres de contenido de las carreras.
     * @return Una lista de carreras de f1 cuyos nombres de contenido comienzan con la cadena proporcionada.
     */
    List<F1Content> findByNombreContenidoStartingWith(String query);
}
