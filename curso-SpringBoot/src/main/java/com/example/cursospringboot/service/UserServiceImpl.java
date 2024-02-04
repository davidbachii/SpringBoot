package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

/*
  JPA implementa metodos transaccionales, por lo que no es necesario usar la anotacion @Transactional
    en los metodos del servicio para que se ejecuten en una transaccion de base de datos.
 */


    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true) //Para que sea solo de lectura, es un metodo de spring no de jakarta
    public Iterable<User> findAll() {

        //Retornamos todos los usuarios que se encuentran en la base de datos
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        //Retornamos todos los usuarios que se encuentran en la base de datos paginados
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        //Retornamos el usuario que se encuentre en la base de datos por su id
        return userRepository.findById(id);
    }

    @Override
    @Transactional //No es necesario aqui declarar que es solo de lectura o escritura ,puede ser ambas
    public User save(User user) {
        //Guardamos el usuario en la base de datos
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        //Eliminamos el usuario de la base de datos por su id
         userRepository.deleteById(id);

    }
}
