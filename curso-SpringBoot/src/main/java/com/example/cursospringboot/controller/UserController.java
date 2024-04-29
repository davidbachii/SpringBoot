package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.Optional;


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
    public ResponseEntity<String> createUser(@RequestParam String Name, @RequestParam String nickname, @RequestParam String apellido, @RequestParam String pswd, @RequestParam String mail, @RequestParam LocalDate FechaNacimiento, HttpSession session) {

        boolean registrado = userService.estaRegistrado(mail);
        if(registrado){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("El usuario ya esta registrado");
        } else {

            User user = new User();
            user.setEmail(mail);
            user.setApellidos(apellido);
            user.setNombre(Name);
            user.setNickname(nickname);
            user.setContrasenha(pswd);
            user.setFechaNacimiento(FechaNacimiento);
            user.setPlanSuscripcion("Sin Plan");
            user.setPagoValidado(false);
            user.setUrl_image_perfil("https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg");
            User createdUser = userService.createUser(user);
            session.setAttribute("user", createdUser);

            return ResponseEntity.status(HttpStatus.OK).body("Usuario creado");
        }


    }


    @PostMapping("/AccederUsuario")
    public ResponseEntity<String> authenticateUser(@RequestParam("mail-2") String email, @RequestParam("pswd-2") String password, HttpSession session) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (userService.authenticateUser(email, password)) {
                if (user.getPlanSuscripcion().equals("Sin Plan")) {
                    // Si el usuario no tiene un plan de suscripción, crear una sesión y redirigir a la página de actualización de plan
                    session.setAttribute("user", user);
                    return ResponseEntity.status(HttpStatus.OK).body("Sin plan de suscripción, por favor selecciona uno.");
                }else if(user.getPagoValidado().equals(false)){
                    session.setAttribute("user", user);
                    return ResponseEntity.status(HttpStatus.OK).body("Pago no validado, por favor valida tu pago.");
                }else {
                    // El usuario tiene un plan de suscripción, redirigir a la página de películas
                    session.setAttribute("user", user);
                    return ResponseEntity.status(HttpStatus.OK).body("Autenticación exitosa");
                }
            } else {
                // Autenticación fallida, devuelve un mensaje de error
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
            }
        } else {
            // Usuario no encontrado, devuelve un mensaje de error
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }
    }






    @PostMapping("/updatePlan")
    public RedirectView updatePlan(@RequestParam String plan, HttpSession session) {
        User user = (User) session.getAttribute("user");

        switch (user.getPlanSuscripcion()) {
            case "Pro" -> {
                return new RedirectView("/api/userProfile/");
            }
            case "Basico" -> {
                if (plan.equals("Gratis") || plan.equals("Basico")) {
                    return new RedirectView("/api/userProfile/");
                }
            }
            case "Gratis" -> {
                if (plan.equals("Gratis")) {
                    return new RedirectView("/api/userProfile/");
                }
            }
        }


        user.setPlanSuscripcion(plan);
        userService.updateUser(user.getEmail(), user);

        if (plan.equals("Gratis")) {
            user.setPagoValidado(true);
            // Assuming you have a UserService to update the user
            userService.updateUser(user.getEmail(), user);
            session.invalidate();
            return new RedirectView("/api/users/");

        } else {

            return new RedirectView("/api/pago/");
        }

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

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.invalidate();
        }
        return "redirect:/api/users/";
    }


    //Estos metodos se van a comunicar con el servicio que se encargara de hacer las operaciones en la base de datos
    //Y el servicio se va a comunicar con el repositorio que se encargara de hacer las consultas a la base de datos
    //Y el repositorio se va a comunicar con la base de datos
    //Y asi se va a hacer el flujo de informacion
    //Controlador -> Servicio -> Repositorio -> Base de datos
    //Y viceversa
    //Base de datos -> Repositorio -> Servicio -> Controlador
}
