package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.Comentario;
import com.example.cursospringboot.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImp implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;


    @Override
    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Optional<Comentario> getComentarioById(Long id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public Comentario createComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public Comentario updateComentario(Long id, Comentario detallesComentario) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario not found"));

        comentario.setTexto(detallesComentario.getTexto());
        comentario.setValoracion(detallesComentario.getValoracion());
        comentario.setFechaComentario(detallesComentario.getFechaComentario());
        comentario.setUsuario(detallesComentario.getUsuario());
        comentario.setPelicula(detallesComentario.getPelicula());
        // Actualiza otros campos según sea necesario

        return comentarioRepository.save(comentario);
    }

    @Override
    public void deleteComentario(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario not found"));

        comentarioRepository.delete(comentario);
    }
}
