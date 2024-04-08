package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.Pelicula;

import java.util.List;
import java.util.Optional;

public interface F1ContentService {


    //Declaramos los metodos que vamos a usar en el servicio del contenido de f1

    //Metodo para obtener todo el contenido de f1
    List<F1Content> getAllF1Content();

    //Metodo para obtener el contenido de f1 por su id
    Optional<F1Content> getF1ContentByNombreCarrera(String nombreCarrera);

    //Metodo para guardar el contenido de f1
    F1Content createF1Content(F1Content f1Content);

    //Metodo para actualizar el contenido de f1
    F1Content updateF1Content(String id, F1Content f1ContentDetails);

    //Metodo para eliminar el contenido de f1
    void deleteF1Content(String nombreCarrera);

    public List<F1Content> searchF1Content(String query);



}
