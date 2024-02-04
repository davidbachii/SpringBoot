package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController //Para que sea un controlador rest de spring boot y no un controlador comun
@RequestMapping("/api/users") //Para que todas las rutas de este controlador empiecen con /api/users
public class UserController {

    //Aqui iran los metodos que se van a usar en el controlador
    //Por ejemplo, para obtener todos los usuarios, obtener un usuario por su id, guardar un usuario, eliminar un usuario, etc.

    //Aqui se va a inyectar el servicio que se va a usar en el controlador

    @Autowired
    private UserService userService;

    //Create a new user
    //Para guardar un usuario en la base de datos usamos el metodo post de http que nos permite enviar datos al servidor
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    //Read an user
    //Para obtener todos los usuarios de la base de datos usamos el metodo get de http que nos permite obtener datos del servidor
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<User> oUser = userService.findById(id);
        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);


    }

    //Update an user
    //Para actualizar un usuario de la base de datos usamos el metodo put de http que nos permite enviar datos al servidor
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        user.get().setName(userDetails.getName());
        user.get().setApellido(userDetails.getApellido());
        user.get().setEmail(userDetails.getEmail());
        user.get().setPassword(userDetails.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    }

    //Delete an user
    //Para eliminar un usuario de la base de datos usamos el metodo delete de http que nos permite enviar datos al servidor
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if (!userService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Read all users
    //Para obtener todos los usuarios de la base de datos usamos el metodo get de http que nos permite obtener datos del servidor
    @GetMapping
    public List<User> readAll() {
        List<User> users = StreamSupport
                .stream(userService.findAll().spliterator(), false)
                .toList();
        return users;
    }


    //Estos metodos se van a comunicar con el servicio que se encargara de hacer las operaciones en la base de datos
    //Y el servicio se va a comunicar con el repositorio que se encargara de hacer las consultas a la base de datos
    //Y el repositorio se va a comunicar con la base de datos
    //Y asi se va a hacer el flujo de informacion
    //Controlador -> Servicio -> Repositorio -> Base de datos
    //Y viceversa
    //Base de datos -> Repositorio -> Servicio -> Controlador
}
