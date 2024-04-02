package com.example.cursospringboot.service;


import com.example.cursospringboot.entity.ComentarioF1;
import com.example.cursospringboot.entity.ComentarioFootball;
import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.FootballContent;
import com.example.cursospringboot.repository.ComentarioFootballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioFootballServiceImp implements ComentarioFootballService{

    @Autowired
    ComentarioFootballRepository comentarioFootballRepository;

    @Override
    public List<ComentarioFootball> getAllComentariosFootball() {
        return comentarioFootballRepository.findAll();
    }

    @Override
    public Optional<ComentarioFootball> getComentarioFootballById(Long id) {
        return comentarioFootballRepository.findById(id);
    }

    @Override
    public ComentarioFootball createComentarioFootballContent(ComentarioFootball comentarioFootball) {
        return comentarioFootballRepository.save(comentarioFootball);
    }

    @Override
    public ComentarioFootball updateComentarioFootballContent(Long id, ComentarioFootball comentarioFootballDetails) {
        ComentarioFootball comentarioFootball = comentarioFootballRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ComentarioFootabll not found with id " + id));
        comentarioFootball.setTexto(comentarioFootballDetails.getTexto());
        comentarioFootball.setNickname(comentarioFootballDetails.getNickname());
        return comentarioFootballRepository.save(comentarioFootball);
    }

    @Override
    public void deleteComentarioFootball(Long id) {
        ComentarioFootball comentarioFootball = comentarioFootballRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ComentarioFootball not found with id " + id));
        comentarioFootballRepository.delete(comentarioFootball);
    }

    @Override
    public List<ComentarioFootball> getAllComentariosByFootballContent(FootballContent footballContent) {
        return comentarioFootballRepository.findByFootballContent(footballContent);
    }
}
