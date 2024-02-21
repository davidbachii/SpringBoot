package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.TarjetaCredito;

import java.util.List;
import java.util.Optional;

public interface TarjetaService {


    //Declaramos los metodos que vamos a usar en el servicio

    //Metodo para obtener todas las tarjetas
    List<TarjetaCredito> getAllTarjetas();

    //Metodo para obtener una tarjeta por su id
    Optional<TarjetaCredito> getTarjetaById(Long id);
    //Metodo para guardar una tarjeta
    TarjetaCredito createTarjeta(TarjetaCredito tarjeta);

    //Metodo para actualizar una tarjeta
    TarjetaCredito updateTarjeta(Long id, TarjetaCredito tarjetaDetails);

    //Metodo para eliminar una tarjeta
    void deleteTarjeta(Long id);


    //Metodo para obtener todas las tarjetas de un usuario
    List<TarjetaCredito> getTarjetasByUserEmail(String email);
}
