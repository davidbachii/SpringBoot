package com.example.cursospringboot.repository;

import com.example.cursospringboot.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    /*
    Tambien podriamos usar crudrepository, pero jpa repository es mas completo y tiene mas metodos para hacer
     consultas a la base de datos y no tener que hacerlo manualmente como en el caso de crudrepository
    */

    /*
    Lo que buscamos es que jpa haga la busqueda por nosotros y no tener que hacerlo manualmente
    Para eso usamos jpa repository que es una interfaz que nos permite hacer consultas a la base de datos
    */



}
