package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.Pelicula;
import com.example.cursospringboot.service.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Controller //Para que sea un controlador rest de spring boot y no un controlador comun
@RequestMapping("/api/peliculas") //Para que todas las rutas de este controlador empiecen con /api/peliculas
public class PeliculaController {

    //Aqui iran los metodos que se van a usar en el controlador
    //Aqui se va a inyectar el servicio que se va a usar en el controlador

    @Autowired
    private PeliculaService peliculaService;




    @GetMapping("/")
    public String getAllPeliculas(Model model) {
        List<Pelicula> listaPeliculas = peliculaService.getAllPeliculas();
        model.addAttribute("listaPeliculas", listaPeliculas);
        return "index";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }


    @GetMapping("/{nombrePelicula}")
    public String getPelicula(@PathVariable String nombrePelicula, Model model) {
        Pelicula pelicula = peliculaService.getPeliculaByNombre(nombrePelicula)
                .orElseThrow(() -> new RuntimeException("Pelicula not found"));
        model.addAttribute("pelicula", pelicula);
        return "indexDetallado";
    }

    @GetMapping("/search/realtime")
    @ResponseBody
    public List<Pelicula> realtimeSearch(@RequestParam String query) {
        return peliculaService.searchPeliculas(query);
    }












































    /*
    @GetMapping
    public ResponseEntity<List<Pelicula>> getAllPeliculas() {
        List<Pelicula> peliculas = peliculaService.getAllPeliculas();
        return new ResponseEntity<>(peliculas, HttpStatus.OK);
    }

    @GetMapping("/{nombrePelicula}")
    public ResponseEntity<Pelicula> getPeliculaByNombre(@PathVariable String nombrePelicula) {
        Optional<Pelicula> pelicula = peliculaService.getPeliculaByNombre(nombrePelicula);
        return pelicula.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        Pelicula createdPelicula = peliculaService.createPelicula(pelicula);
        return new ResponseEntity<>(createdPelicula, HttpStatus.CREATED);
    }

    @PutMapping("/{nombrePelicula}")
    public ResponseEntity<Pelicula> updatePelicula(@PathVariable String nombrePelicula, @RequestBody Pelicula detallesPelicula) {
        try {
            Pelicula updatedPelicula = peliculaService.updatePelicula(nombrePelicula, detallesPelicula);
            return new ResponseEntity<>(updatedPelicula, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{nombrePelicula}")
    public ResponseEntity<Void> deletePelicula(@PathVariable String nombrePelicula) {
        try {
            peliculaService.deletePelicula(nombrePelicula);
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

    */

}
