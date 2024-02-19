package com.example.cursospringboot.repository;

import com.example.cursospringboot.entity.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TarjetaRepository extends JpaRepository<TarjetaCredito, Long>{

    /*
    Lo que buscamos es que jpa haga la busqueda por nosotros y no tener que hacerlo manualmente
    Para eso usamos jpa repository que es una interfaz que nos permite hacer consultas a la base de datos
    */
}
