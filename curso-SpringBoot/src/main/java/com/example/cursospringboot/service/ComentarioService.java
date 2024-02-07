package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ComentarioService {

    //Declaramos los metodos que vamos a usar en el servicio

    //Iterable es una interfaz que nos permite recorrer una lista de elementos de cualquier tipo
    public Iterable<Comentario> findAll();

    //Page es una interfaz que nos permite paginar los resultados de una consulta a la base de datos
    public Page<Comentario> findAll(Pageable pageable);

    //Optional es una interfaz que nos permite trabajar con objetos que pueden ser nulos o no
    public Optional<Comentario> findById(Long id);

    //Save nos permite guardar un comentario en la base de datos y nos devuelve el comentario guardado
    public Comentario save(Comentario comentario);

    //Delete nos permite eliminar un comentario de la base de datos por su id
    public void deleteById(Long id);
}
