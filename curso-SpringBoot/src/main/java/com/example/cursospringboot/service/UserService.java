package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.User;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface UserService {

    //Declaramos los metodos que vamos a usar en el servicio

    //Iterable es una interfaz que nos permite recorrer una lista de elementos de cualquier tipo
    public Iterable<User> findAll();

    //Page es una interfaz que nos permite paginar los resultados de una consulta a la base de datos
    public Page<User> findAll(Pageable pageable);

    //Optional es una interfaz que nos permite trabajar con objetos que pueden ser nulos o no
    public Optional<User> findById(Long id);

    //Save nos permite guardar un usuario en la base de datos y nos devuelve el usuario guardado
    public User save(User user);

    //Delete nos permite eliminar un usuario de la base de datos por su id
    public void deleteById(Long id);
}
