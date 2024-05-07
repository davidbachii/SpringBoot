package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.ComentarioPelicula;
import com.example.cursospringboot.entity.Pelicula;

import java.util.List;
import java.util.Optional;

public interface ComentarioPeliculaService {

    List<ComentarioPelicula> getAllComentariosPelicula();
    Optional<ComentarioPelicula> getComentarioPeliculaById(Long id);
    ComentarioPelicula createComentarioPelicula(ComentarioPelicula comentarioPelicula);
    ComentarioPelicula updateComentarioPelicula(Long id, ComentarioPelicula comentarioPeliculaDetails);
    void deleteComentarioPelicula(Long id);
    List<ComentarioPelicula> getAllComentariosByPelicula(Pelicula pelicula);

    void deleteComentariosByPelicula(String nombrePelicula);
}
