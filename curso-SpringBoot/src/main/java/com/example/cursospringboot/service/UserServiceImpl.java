package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.Role;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

/*
  JPA implementa metodos transaccionales, por lo que no es necesario usar la anotacion @Transactional
    en los metodos del servicio para que se ejecuten en una transaccion de base de datos.
 */


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;


    //Metodo para obtener todos los usuarios
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Metodo para obtener un usuario por su email
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findById(email);
    }


    //Metodo para guardar un usuario
    @Override
    public User createUser(User user) {
        User createdUser = userRepository.save(user);
        roleService.assignRoleToUser(createdUser.getEmail(), "USER"); // Asignar el rol de "USER" por defecto
        return createdUser;
    }


    //Metodo para actualizar un usuario
    @Override
    public User updateUser(String email, User userDetails) {
        User user = userRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setNombre(userDetails.getNombre());
        user.setNickname(userDetails.getNickname());
        user.setContrasenha(userDetails.getContrasenha());
        user.setFechaNacimiento(userDetails.getFechaNacimiento());
        user.setPlanSuscripcion(userDetails.getPlanSuscripcion());
        user.setApellidos(userDetails.getApellidos());
        user.setPagoValidado(userDetails.getPagoValidado());
        user.setUrl_image_perfil(userDetails.getUrl_image_perfil());

        return userRepository.save(user);
    }
    //Metodo para eliminar un usuario
    @Override
    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }


    // Metodo para la autenticacion de un usuario
    @Override
    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findById(email).orElse(null);

        if(user == null){
            return false;
        }
        return user.getContrasenha().equals(password);
    }

    @Override
    public boolean estaRegistrado(String email) {
        return userRepository.existsById(email);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean nicknameExists(String nickname) {
        return userRepository.existsByNickname(nickname);
    }
}

