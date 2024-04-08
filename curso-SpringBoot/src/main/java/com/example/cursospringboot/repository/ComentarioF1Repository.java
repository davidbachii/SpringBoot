package com.example.cursospringboot.repository;


import com.example.cursospringboot.entity.ComentarioF1;
import com.example.cursospringboot.entity.ComentarioPelicula;
import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioF1Repository extends JpaRepository<ComentarioF1, Long> {

    List<ComentarioF1> findByF1Content(F1Content f1Content);
}
