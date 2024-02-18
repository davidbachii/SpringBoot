package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Controller // Esto es para que sea un controlador de spring boot
@RequestMapping("/api/users") //Para que todas las rutas de este controlador empiecen con /api/users
public class UserController {

    //Aqui iran los metodos que se van a usar en el controlador
    //Por ejemplo, para obtener todos los usuarios, obtener un usuario por su id, guardar un usuario, eliminar un usuario, etc.

    //Aqui se va a inyectar el servicio que se va a usar en el controlador

    @Autowired
    private UserService userService;



    /*
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        try {
            Optional<User> user = userService.getUserByEmail(email);
            if (user.isPresent()) {
                return new ResponseEntity<>(user.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    */

    @PostMapping("/CrearUsuario")
    public RedirectView createUser(@RequestParam String Name, @RequestParam String Apellidos, @RequestParam String pswd, @RequestParam String mail, @RequestParam LocalDate FechaNacimiento, HttpSession session) {
        User user = new User();
        user.setEmail(mail);
        user.setNombre(Name);
        user.setApellidos(Apellidos);
        user.setContrasenha(pswd);
        user.setFechaNacimiento(FechaNacimiento);
        user.setPlanSuscripcion("Sin Plan");
        User createdUser = userService.createUser(user);
        session.setAttribute("user", createdUser);
        return new RedirectView("/api/users/planSuscripcion");
    }

    @PostMapping("/AccederUsuario")
    public ResponseEntity<User> loginUser(@RequestParam String mail, @RequestParam String pswd) {
        Optional<User> user = userService.getUserByEmail(mail);
        if (user.isPresent() && user.get().getContrasenha().equals(pswd)) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/updatePlan")
    public RedirectView updatePlan(@RequestParam String plan, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setPlanSuscripcion(plan);
        userService.updateUser(user.getEmail(), user);
        return new RedirectView("/api/users/");
    }


    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody User userDetails) {
        try {
            User updatedUser = userService.updateUser(email, userDetails);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/")
    public String root() {
        return "login";
    }

    @GetMapping("/planSuscripcion")
    public String root2(HttpSession session) {
        // Comprobar si el usuario está registrado
        if (session.getAttribute("user") == null) {
            // Redirigir al usuario a la página de inicio de sesión si no está registrado
            return "login";
        }
        // Si el usuario está registrado, continuar como antes
        return "planSuscripcion";
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        try {
            userService.deleteUser(email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Estos metodos se van a comunicar con el servicio que se encargara de hacer las operaciones en la base de datos
    //Y el servicio se va a comunicar con el repositorio que se encargara de hacer las consultas a la base de datos
    //Y el repositorio se va a comunicar con la base de datos
    //Y asi se va a hacer el flujo de informacion
    //Controlador -> Servicio -> Repositorio -> Base de datos
    //Y viceversa
    //Base de datos -> Repositorio -> Servicio -> Controlador
}
