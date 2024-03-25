package com.example.cursospringboot.service;


import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.FootballContent;
import com.example.cursospringboot.entity.Pelicula;
import com.example.cursospringboot.repository.FootballContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballContentServiceImp implements FootballContentService{


    @Autowired
    private FootballContentRepository footballContentRepository;


    // Implementación de los métodos del repositorio
    @Override
    public List<FootballContent> getAllFootballContent() {
        return footballContentRepository.findAll();
    }

    @Override
    public Optional<FootballContent> getFootballContentByNombrePartido(String nombrePartido) {
        return footballContentRepository.findByNombreContenido(nombrePartido);
    }

    @Override
    public FootballContent createFootballContent(FootballContent footballContent) {
        return footballContentRepository.save(footballContent);
    }

    @Override
    public FootballContent updateFootballContent(String nombrePartido, FootballContent footballContentDetails) {
        FootballContent footballContent = footballContentRepository.findByNombreContenido(nombrePartido)
                .orElseThrow(() -> new RuntimeException("FootballContent not found"));

        footballContent.setAnho(footballContentDetails.getAnho());
        footballContent.setDescripcion(footballContentDetails.getDescripcion());
        footballContent.setDuracion(footballContentDetails.getDuracion());
        footballContent.setEstadio(footballContentDetails.getEstadio());
        footballContent.setJugadores(footballContentDetails.getJugadores());
        footballContent.setNacionalidad(footballContentDetails.getNacionalidad());
        footballContent.setAnho(footballContentDetails.getAnho());
        footballContent.setOtrosDatos(footballContentDetails.getOtrosDatos());
        footballContent.setNombreContenido(footballContentDetails.getNombreContenido());
        footballContent.setUrl_image(footballContentDetails.getUrl_image());
        footballContent.setUrl_video(footballContentDetails.getUrl_video());
        // Actualiza otros campos según sea necesario

        return footballContentRepository.save(footballContent);


    }

    @Override
    public void deleteFootballContent(String nombrePartido) {
        FootballContent footballContent = footballContentRepository.findByNombreContenido(nombrePartido)
                .orElseThrow(() -> new RuntimeException("Carrera de F1 not found"));
        footballContentRepository.delete(footballContent);
    }

    @Override
    public List<FootballContent> searchFootballContent(String query) {
        return footballContentRepository.findByNombreContenidoStartingWith(query);
    }





}
