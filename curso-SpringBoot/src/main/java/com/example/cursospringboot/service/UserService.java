package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.User;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //Declaramos los metodos que vamos a usar en el servicio

    //Metodo para obtener todos los usuarios
    List<User> getAllUsers();

    //Metodo para obtener un usuario por su email
    Optional<User> getUserByEmail(String email);
    //Metodo para guardar un usuario
    User createUser(User user);

    //Metodo para actualizar un usuario
    User updateUser(String email, User userDetails);

    //Metodo para eliminar un usuario
    void deleteUser(String email);

}
