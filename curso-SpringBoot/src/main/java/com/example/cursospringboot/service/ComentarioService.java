package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ComentarioService {

    //Declaramos los metodos que vamos a usar en el servicio

    //Metodo para obtener todos los comentarios
    List<Comentario> getAllComentarios();

    //Metodo para obtener un comentario por su id
    Optional<Comentario> getComentarioById(Long id);

    //Metodo para guardar un comentario
    Comentario createComentario(Comentario comentario);

    //Metodo para actualizar un comentario
    Comentario updateComentario(Long id, Comentario detallesComentario);

    //Metodo para eliminar un comentario
    void deleteComentario(Long id);
}
