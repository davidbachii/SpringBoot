package com.example.cursospringboot.service;


import com.example.cursospringboot.entity.Pelicula;
import com.example.cursospringboot.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImp implements PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getAllPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> getPeliculaByNombre(String nombrePelicula) {
        return peliculaRepository.findById(nombrePelicula);
    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(String nombrePelicula, Pelicula detallesPelicula) {
        Pelicula pelicula = peliculaRepository.findById(nombrePelicula)
                .orElseThrow(() -> new RuntimeException("Pelicula not found"));

        pelicula.setNombrePelicula(detallesPelicula.getNombrePelicula());
        pelicula.setSinopsis(detallesPelicula.getSinopsis());
        pelicula.setPaginaOficial(detallesPelicula.getPaginaOficial());
        pelicula.setTituloOriginal(detallesPelicula.getTituloOriginal());
        pelicula.setGenero(detallesPelicula.getGenero());
        pelicula.setNacionalidad(detallesPelicula.getNacionalidad());
        pelicula.setDuracion(detallesPelicula.getDuracion());
        pelicula.setAnho(detallesPelicula.getAnho());
        pelicula.setDistribuidora(detallesPelicula.getDistribuidora());
        pelicula.setDirector(detallesPelicula.getDirector());
        pelicula.setClasificacionEdad(detallesPelicula.getClasificacionEdad());
        pelicula.setOtrosDatos(detallesPelicula.getOtrosDatos());
        pelicula.setActores(detallesPelicula.getActores());
        pelicula.setUrl_image(detallesPelicula.getUrl_image());
        pelicula.setUrl_video(detallesPelicula.getUrl_video());
        pelicula.setCalificacion(detallesPelicula.getCalificacion());
        // Actualiza otros campos según sea necesario

        return peliculaRepository.save(pelicula);
    }

    @Override
    public void deletePelicula(String nombrePelicula) {
        peliculaRepository.deleteById(nombrePelicula);
    }


}
