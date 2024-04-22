package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.ComentarioPelicula;
import com.example.cursospringboot.entity.Pelicula;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.ComentarioPeliculaService;
import com.example.cursospringboot.service.PeliculaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/api/ComentariosPelicula")
public class ComentarioPeliculaController {


    //Aqui se va a inyectar el servicio que se va a usar en el controlador

    @Autowired
    private ComentarioPeliculaService comentarioPeliculaService;

    @Autowired
    private PeliculaService peliculaService;


    @PostMapping("/CrearComentarioPelicula/{nombrePelicula}")
    public String createComentarioPelicula(@PathVariable String nombrePelicula, @RequestParam String textoComentario, @RequestParam Short valoracionComentario, HttpSession session) {
        // Obtener el usuario de la sesión
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }

        // Obtener la película por su nombre
        Pelicula pelicula = peliculaService.getPeliculaByNombre(nombrePelicula)
                .orElseThrow(() -> new RuntimeException("Pelicula not found"));

        //Obtener el nickname del usuario
        String nickname = user.getNickname();

        // Crear el comentario
        ComentarioPelicula comentarioPelicula = new ComentarioPelicula();
        comentarioPelicula.setTexto(textoComentario);
        comentarioPelicula.setNickname(nickname);
        comentarioPelicula.setValoracion(valoracionComentario);
        comentarioPelicula.setFechaComentario();
        comentarioPelicula.setUsuario(user);
        comentarioPelicula.setPelicula(pelicula);

        // Guardar el comentario
        comentarioPeliculaService.createComentarioPelicula(comentarioPelicula);

        // Redirigir a la página de detalles de la película
        return "redirect:/api/peliculas/" + comentarioPelicula.getPelicula().getNombreContenido();
    }
}
