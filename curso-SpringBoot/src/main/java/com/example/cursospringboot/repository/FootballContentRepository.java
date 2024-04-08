package com.example.cursospringboot.repository;

import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.FootballContent;
import com.example.cursospringboot.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FootballContentRepository extends JpaRepository<FootballContent, Long> {

    Optional<FootballContent> findByNombreContenido(String nombreContenido);

    /**
     * Busca partidos de futbol cuyos nombres de contenido comiencen con una determinada cadena.
     *
     * @param query La cadena con la que deben comenzar los nombres de contenido de los partidos.
     * @return Una lista de partidos de futbol cuyos nombres de contenido comienzan con la cadena proporcionada.
     */
    List<FootballContent> findByNombreContenidoStartingWith(String query);

    List<FootballContent> findByCompeticion(String competicion);
}
