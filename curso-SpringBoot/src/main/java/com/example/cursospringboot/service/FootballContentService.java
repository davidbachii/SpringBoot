package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.FootballContent;

import java.util.List;
import java.util.Optional;

public interface FootballContentService {

    List<FootballContent> getAllFootballContent();

    Optional<FootballContent> getFootballContentByNombrePartido(Long id);

    FootballContent createFootballContent(FootballContent footballContent);

    FootballContent updateFootballContent(Long id, FootballContent footballContentDetails);

    void deleteFootballContent(Long id);
}