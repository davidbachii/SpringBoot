package com.example.cursospringboot.controller;

import com.example.cursospringboot.entity.*;
import com.example.cursospringboot.service.ComentarioF1Service;
import com.example.cursospringboot.service.ComentarioPeliculaService;
import com.example.cursospringboot.service.F1ContentService;
import com.example.cursospringboot.service.PeliculaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/ComentariosF1")
public class ComentarioF1Controller {

    @Autowired
    private ComentarioF1Service comentarioF1Service;

    @Autowired
    private F1ContentService f1ContentService;


    @PostMapping("/CrearComentarioF1/{nombreContenido}")
    public String createComentarioF1(@PathVariable String nombreContenido, @RequestParam String textoComentario, HttpSession session) {
        // Obtener el usuario de la sesión
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new RuntimeException("No user session found");
        }

        // Obtener la película por su nombre
        F1Content f1Content = f1ContentService.getF1ContentByNombreCarrera(nombreContenido)
                .orElseThrow(() -> new RuntimeException("Pelicula not found"));

        //Obtener el nickname del usuario
        String nickname = user.getNickname();

        // Crear el comentario
        ComentarioF1 comentarioF1 = new ComentarioF1();
        comentarioF1.setTexto(textoComentario);
        comentarioF1.setNickname(nickname);
        comentarioF1.setFechaComentario();
        comentarioF1.setUsuario(user);
        comentarioF1.setF1Content(f1Content);

        // Guardar el comentario
        comentarioF1Service.createComentarioF1(comentarioF1);

        // Redirigir a la página de detalles de la película
        return "redirect:/api/F1/" + nombreContenido;
    }
}
