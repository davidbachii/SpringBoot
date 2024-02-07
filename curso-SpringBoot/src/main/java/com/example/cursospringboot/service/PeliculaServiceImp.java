package com.example.cursospringboot.service;


import com.example.cursospringboot.entity.Pelicula;
import com.example.cursospringboot.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PeliculaServiceImp implements PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    @Transactional(readOnly = true) //Para que sea solo de lectura, es un metodo de spring no de jakarta
    public Iterable<Pelicula> findAll() {

        //Retornamos todas las peliculas que se encuentran en la base de datos
        return peliculaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Pelicula> findAll(Pageable pageable) {
        //Retornamos todas las pelicula que se encuentran en la base de datos paginados
        return peliculaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula findBynombrePelicula(String nombre) {
        //Retornamos la pelicula que se encuentre en la base de datos por su id
        return peliculaRepository.findBynombrePelicula(nombre);
    }

    @Override
    @Transactional //No es necesario aqui declarar que es solo de lectura o escritura ,puede ser ambas
    public Pelicula save(Pelicula pelicula) {
        //Guardamos la pelicula en la base de datos
        return peliculaRepository.save(pelicula);
    }

    @Override
    @Transactional
    public void deleteBynombrePelicula(String nombre) {
        //Eliminamos la pelicula de la base de datos por su id
        peliculaRepository.deleteBynombrePelicula(nombre);

    }


}
