package com.example.cursospringboot.repository;

import com.example.cursospringboot.entity.ComentarioPelicula;
import com.example.cursospringboot.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioPeliculaRepository extends JpaRepository<ComentarioPelicula, Long> {

    List<ComentarioPelicula> findByPelicula(Pelicula pelicula);

}