package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.Comentario;
import com.example.cursospringboot.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ComentarioServiceImp implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;


    @Override
    @Transactional(readOnly = true) //Para que sea solo de lectura, es un metodo de spring no de jakarta
    public Iterable<Comentario> findAll() {

        //Retornamos todos los comentarios que se encuentran en la base de datos
        return comentarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Comentario> findAll(Pageable pageable) {
        //Retornamos todos los comentarios que se encuentran en la base de datos paginados
        return comentarioRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comentario> findById(Long id) {
        //Retornamos el comentario que se encuentre en la base de datos por su id
        return comentarioRepository.findById(id);
    }

    @Override
    @Transactional //No es necesario aqui declarar que es solo de lectura o escritura ,puede ser ambas
    public Comentario save(Comentario comentario) {
        //Guardamos el comentario en la base de datos
        return comentarioRepository.save(comentario);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        //Eliminamos el comentario de la base de datos por su id
        comentarioRepository.deleteById(id);

    }
}
