package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.ComentarioF1;
import com.example.cursospringboot.entity.ComentarioPelicula;
import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.Pelicula;

import java.util.List;
import java.util.Optional;

public interface ComentarioF1Service {

    List<ComentarioF1> getAllComentariosF1();
    Optional<ComentarioF1> getComentarioF1ById(Long id);
    ComentarioF1 createComentarioF1(ComentarioF1 ComentarioF1);
    ComentarioF1 updateComentarioF1(Long id, ComentarioF1 comentarioF1);
    void deleteComentarioF1(Long id);
    List<ComentarioF1> getAllComentariosByF1(F1Content f1Content);

    void deleteComentariosByF1Content(String nombreCarreraF1);
}
