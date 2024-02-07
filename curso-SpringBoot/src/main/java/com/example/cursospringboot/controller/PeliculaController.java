package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.Pelicula;

import com.example.cursospringboot.service.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController //Para que sea un controlador rest de spring boot y no un controlador comun
@RequestMapping("/api/peliculas") //Para que todas las rutas de este controlador empiecen con /api/peliculas
public class PeliculaController {

    //Aqui iran los metodos que se van a usar en el controlador
    //Por ejemplo, para obtener todos los usuarios, obtener un usuario por su id, guardar un usuario, eliminar un usuario, etc.

    //Aqui se va a inyectar el servicio que se va a usar en el controlador

    @Autowired
    private PeliculaService peliculaService;

    //Create a new film
    //Para guardar una pelicula en la base de datos usamos el metodo post de http que nos permite enviar datos al servidor
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pelicula pelicula) {
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaService.save(pelicula));
    }

    //Read a film
    //Para obtener peliculas de la base de datos usamos el metodo get de http que nos permite obtener datos del servidor
    @GetMapping("/{nombrePelicula}")
    public ResponseEntity<?> read(@PathVariable(value = "nombrePelicula") String nombrePelicula) {
        Pelicula pelicula = peliculaService.findBynombrePelicula(nombrePelicula);
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pelicula);
    }

    //Update a film
    //Para actualizar una pelicula de la base de datos usamos el metodo put de http que nos permite enviar datos al servidor
    @PutMapping("/{nombrePelicula}")
    public ResponseEntity<?> update(@RequestBody Pelicula peliculaDetails, @PathVariable(value = "nombrePelicula") String nombrePelicula) {
        Pelicula pelicula = peliculaService.findBynombrePelicula(nombrePelicula);
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }

        pelicula.setNombrePelicula(peliculaDetails.getNombrePelicula());
        pelicula.setSinopsis(peliculaDetails.getSinopsis());
        pelicula.setPaginaOficial(peliculaDetails.getPaginaOficial());
        pelicula.setTituloOriginal(peliculaDetails.getTituloOriginal());
        pelicula.setGenero(peliculaDetails.getGenero());
        pelicula.setNacionalidad(peliculaDetails.getNacionalidad());
        pelicula.setDuracion(peliculaDetails.getDuracion());
        pelicula.setAnho(peliculaDetails.getAnho());
        pelicula.setDistribuidora(peliculaDetails.getDistribuidora());
        pelicula.setDirector(peliculaDetails.getDirector());
        pelicula.setClasificacionEdad(peliculaDetails.getClasificacionEdad());
        pelicula.setOtrosDatos(peliculaDetails.getOtrosDatos());
        pelicula.setActores(peliculaDetails.getActores());
        pelicula.setUrl_image(peliculaDetails.getUrl_image());
        pelicula.setUrl_video(peliculaDetails.getUrl_video());

        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaService.save(pelicula));
    }

    //Delete a film
    //Para eliminar una pelicula de la base de datos usamos el metodo delete de http que nos permite enviar datos al servidor
    @DeleteMapping("/{nombrePelicula}")
    public ResponseEntity<?> delete(@PathVariable(value = "nombrePelicula") String nombrePelicula) {
        if (peliculaService.findBynombrePelicula(nombrePelicula) == null) {
            return ResponseEntity.notFound().build();
        }
        peliculaService.deleteBynombrePelicula(nombrePelicula);
        return ResponseEntity.ok().build();
    }


    //Read all films
    //Para obtener todas los peliculas de la base de datos usamos el metodo get de http que nos permite obtener datos del servidor
    @GetMapping
    public List<Pelicula> readAll() {
        List<Pelicula> pelicula = StreamSupport
                .stream(peliculaService.findAll().spliterator(), false)
                .toList();
        return pelicula;
    }


    //Estos metodos se van a comunicar con el servicio que se encargara de hacer las operaciones en la base de datos
    //Y el servicio se va a comunicar con el repositorio que se encargara de hacer las consultas a la base de datos
    //Y el repositorio se va a comunicar con la base de datos
    //Y asi se va a hacer el flujo de informacion
    //Controlador -> Servicio -> Repositorio -> Base de datos
    //Y viceversa
    //Base de datos -> Repositorio -> Servicio -> Controlador
}
