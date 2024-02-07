package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.Comentario;
import com.example.cursospringboot.entity.Pelicula;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.ComentarioService;
import com.example.cursospringboot.service.PeliculaService;
import com.example.cursospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController //Para que sea un controlador rest de spring boot y no un controlador comun
@RequestMapping("/api/comentarios") //Para que todas las rutas de este controlador empiecen con /api/peliculas
public class ComentarioController {


    //Aqui iran los metodos que se van a usar en el controlador
    //Por ejemplo, para obtener todos los usuarios, obtener un usuario por su id, guardar un usuario, eliminar un usuario, etc.

    //Aqui se va a inyectar el servicio que se va a usar en el controlador

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private UserService userService;


    //Create a new comment
    //Para guardar un comentario en la base de datos usamos el metodo post de http que nos permite enviar datos al servidor
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Comentario comentario) {
        Optional<User> user = userService.getUserByEmail(comentario.getUsuario().getEmail());
        Pelicula pelicula = peliculaService.findBynombrePelicula(comentario.getPelicula().getNombrePelicula());

        if (user == null || pelicula == null) {
            return ResponseEntity.notFound().build();
        }

        comentario.setUsuario(user.get());
        comentario.setPelicula(pelicula);

        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.save(comentario));
    }

    //Read a comment
    //Para obtener todos los comentario de la base de datos usamos el metodo get de http que nos permite obtener datos del servidor
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Comentario> oComentario = comentarioService.findById(id);
        if (!oComentario.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oComentario);


    }

    //Update a comment
    //Para actualizar un comentario de la base de datos usamos el metodo put de http que nos permite enviar datos al servidor
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Comentario comentarioDetails, @PathVariable(value = "id") Long id) {
        Optional<Comentario> comentario = comentarioService.findById(id);
        if (!comentario.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        comentario.get().setTexto(comentarioDetails.getTexto());
        comentario.get().setValoracion(comentarioDetails.getValoracion());
        comentario.get().setFechaComentario(comentarioDetails.getFechaComentario());
        comentario.get().setUsuario(comentarioDetails.getUsuario());
        comentario.get().setPelicula(comentarioDetails.getPelicula());
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.save(comentario.get()));
    }

    //Delete a comment
    //Para eliminar un comentario de la base de datos usamos el metodo delete de http que nos permite enviar datos al servidor
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if (!comentarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        comentarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Read all comments
    //Para obtener todos los comentario de la base de datos usamos el metodo get de http que nos permite obtener datos del servidor
    @GetMapping
    public List<Comentario> readAll() {
        List<Comentario> comentarios = (List<Comentario>) comentarioService.findAll();
        return comentarios;
    }


    //Estos metodos se van a comunicar con el servicio que se encargara de hacer las operaciones en la base de datos
    //Y el servicio se va a comunicar con el repositorio que se encargara de hacer las consultas a la base de datos
    //Y el repositorio se va a comunicar con la base de datos
    //Y asi se va a hacer el flujo de informacion
    //Controlador -> Servicio -> Repositorio -> Base de datos
    //Y viceversa
    //Base de datos -> Repositorio -> Servicio -> Controlador
}
