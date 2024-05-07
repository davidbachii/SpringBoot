package com.example.cursospringboot.service;


import com.example.cursospringboot.entity.ComentarioPelicula;
import com.example.cursospringboot.entity.Pelicula;
import com.example.cursospringboot.repository.ComentarioPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioPeliculaServiceImp implements ComentarioPeliculaService {

    @Autowired
    private ComentarioPeliculaRepository comentarioPeliculaRepository;

    @Autowired
    private PeliculaService peliculaService;

    @Override
    public List<ComentarioPelicula> getAllComentariosPelicula() {
        return comentarioPeliculaRepository.findAll();
    }

    @Override
    public Optional<ComentarioPelicula> getComentarioPeliculaById(Long id) {
        return comentarioPeliculaRepository.findById(id);
    }

    @Override
    public ComentarioPelicula createComentarioPelicula(ComentarioPelicula comentarioPelicula) {
        return comentarioPeliculaRepository.save(comentarioPelicula);
    }

    @Override
    public ComentarioPelicula updateComentarioPelicula(Long id, ComentarioPelicula comentarioPeliculaDetails) {
        ComentarioPelicula comentarioPelicula = getComentarioPeliculaById(id)
                .orElseThrow(() -> new RuntimeException("ComentarioPelicula not found with id " + id));

        comentarioPelicula.setTexto(comentarioPeliculaDetails.getTexto());
        comentarioPelicula.setValoracion(comentarioPeliculaDetails.getValoracion());
        comentarioPelicula.setNickname(comentarioPeliculaDetails.getNickname());


        return comentarioPeliculaRepository.save(comentarioPelicula);
    }

    @Override
    public void deleteComentarioPelicula(Long id) {
        ComentarioPelicula comentarioPelicula = getComentarioPeliculaById(id)
                .orElseThrow(() -> new RuntimeException("ComentarioPelicula not found with id " + id));
        comentarioPeliculaRepository.delete(comentarioPelicula);
    }
    @Override
    public List<ComentarioPelicula> getAllComentariosByPelicula(Pelicula pelicula) {
        return comentarioPeliculaRepository.findByPelicula(pelicula);
    }

    @Override
    public void deleteComentariosByPelicula(String nombrePelicula) {
        // Fetch the movie by its name
        Pelicula pelicula = peliculaService.getPeliculaByNombre(nombrePelicula)
                .orElseThrow(() -> new RuntimeException("Pelicula not found with name " + nombrePelicula));
        // Fetch all comments associated with the movie
        List<ComentarioPelicula> comentarios = comentarioPeliculaRepository.findByPelicula(pelicula);
        // Delete all fetched comments
        comentarioPeliculaRepository.deleteAll(comentarios);
    }
}

// Path: src/main/java/com/example/cursospringboot/service/ComentarioPeliculaServiceImp.java
