package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.FootballContent;
import com.example.cursospringboot.entity.Pelicula;

import java.util.List;
import java.util.Optional;

public interface FootballContentService {

    List<FootballContent> getAllFootballContent();

    Optional<FootballContent> getFootballContentByNombrePartido(String nombrePartido);

    FootballContent createFootballContent(FootballContent footballContent);

    FootballContent updateFootballContent(String nombrePartido, FootballContent footballContentDetails);

    void deleteFootballContent(String nombrePartido);

    public List<FootballContent> searchFootballContent(String query);

    List<FootballContent> getFootballContentByCompeticion(String competicion);

}