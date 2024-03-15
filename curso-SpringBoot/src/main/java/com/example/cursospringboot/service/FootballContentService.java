package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.FootballContent;

import java.util.List;
import java.util.Optional;

public interface FootballContentService {

    List<FootballContent> getAllFootballContent();

    Optional<FootballContent> getFootballContentByNombrePartido(String nombrePartido);

    FootballContent createFootballContent(FootballContent footballContent);

    FootballContent updateFootballContent(String nombrePartido, FootballContent footballContentDetails);

    void deleteFootballContent(String nombrePartido);



}