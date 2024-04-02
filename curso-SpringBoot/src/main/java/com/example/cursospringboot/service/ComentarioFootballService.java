package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.ComentarioF1;
import com.example.cursospringboot.entity.ComentarioFootball;
import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.FootballContent;

import java.util.List;
import java.util.Optional;

public interface ComentarioFootballService {

    List<ComentarioFootball> getAllComentariosFootball();
    Optional<ComentarioFootball> getComentarioFootballById(Long id);
    ComentarioFootball createComentarioFootballContent(ComentarioFootball comentarioFootball);
    ComentarioFootball updateComentarioFootballContent(Long id, ComentarioFootball comentarioFootball);
    void deleteComentarioFootball(Long id);
    List<ComentarioFootball> getAllComentariosByFootballContent(FootballContent footballContent);
}
