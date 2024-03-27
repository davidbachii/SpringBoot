package com.example.cursospringboot.service;


import com.example.cursospringboot.entity.ComentarioF1;
import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.repository.ComentarioF1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Comentariof1ServiceImp implements ComentarioF1Service{

    @Autowired
    private ComentarioF1Repository comentarioF1Repository;


    @Override
    public List<ComentarioF1> getAllComentariosF1() {
        return comentarioF1Repository.findAll();
    }

    @Override
    public Optional<ComentarioF1> getComentarioF1ById(Long id) {
        return comentarioF1Repository.findById(id);
    }

    @Override
    public ComentarioF1 createComentarioF1(ComentarioF1 comentarioF1) {
        return comentarioF1Repository.save(comentarioF1);
    }

    @Override
    public ComentarioF1 updateComentarioF1(Long id, ComentarioF1 comentarioF1Details) {
        ComentarioF1 comentarioF1 = comentarioF1Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ComentarioF1 not found with id " + id));
        comentarioF1.setTexto(comentarioF1Details.getTexto());
        comentarioF1.setNickname(comentarioF1Details.getNickname());
        return comentarioF1Repository.save(comentarioF1);
    }

    @Override
    public void deleteComentarioF1(Long id) {
        ComentarioF1 comentarioF1 = comentarioF1Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ComentarioF1 not found with id " + id));
        comentarioF1Repository.delete(comentarioF1);
    }

    @Override
    public List<ComentarioF1> getAllComentariosByF1(F1Content f1Content) {
        return comentarioF1Repository.findByF1Content(f1Content);
    }


}
