package com.example.cursospringboot.service;


import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.Pelicula;
import com.example.cursospringboot.repository.F1ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class F1ContentServiceImp  implements F1ContentService{

    @Autowired
    private F1ContentRepository f1ContentRepository;


    // Implementación de los métodos del repositorio
    @Override
    public List<F1Content> getAllF1Content() {
        return f1ContentRepository.findAll();
    }

    @Override
    public Optional<F1Content> getF1ContentByNombreCarrera(String nombreCarrera) {
        return f1ContentRepository.findByNombreContenido(nombreCarrera);
    }


    @Override
    public F1Content createF1Content(F1Content f1Content) {
        return f1ContentRepository.save(f1Content);
    }

    @Override
    public F1Content updateF1Content(String nombreCarrera, F1Content f1ContentDetails) {
        F1Content f1Content = f1ContentRepository.findByNombreContenido(nombreCarrera)
                .orElseThrow(() -> new RuntimeException("F1Content not found"));

        f1Content.setAnho(f1ContentDetails.getAnho());
        f1Content.setCircuito(f1ContentDetails.getCircuito());
        f1Content.setDuracion(f1ContentDetails.getDuracion());
        f1Content.setEquipos(f1ContentDetails.getEquipos());
        f1Content.setNacionalidad(f1ContentDetails.getNacionalidad());
        f1Content.setDescripcion(f1ContentDetails.getDescripcion());
        f1Content.setPilotos(f1ContentDetails.getPilotos());
        f1Content.setNombreContenido(f1ContentDetails.getNombreContenido());
        f1Content.setDuracion(f1ContentDetails.getDuracion());
        f1Content.setUrl_image(f1ContentDetails.getUrl_image());
        f1Content.setUrl_video(f1ContentDetails.getUrl_video());
        // Actualiza otros campos según sea necesario

        return f1ContentRepository.save(f1Content);
    }

    @Override
    public void deleteF1Content(String nombreCarrera) {
        F1Content f1 = f1ContentRepository.findByNombreContenido(nombreCarrera)
                .orElseThrow(() -> new RuntimeException("Carrera de F1 not found"));
        f1ContentRepository.delete(f1);
    }


    @Override
    public List<F1Content> searchF1Content(String query) {
        return f1ContentRepository.findByNombreContenidoStartingWith(query);
    }






}
