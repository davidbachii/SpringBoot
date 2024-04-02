package com.example.cursospringboot.controller;



import com.example.cursospringboot.entity.*;
import com.example.cursospringboot.service.ComentarioFootballService;
import com.example.cursospringboot.service.FootballContentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/ComentariosFootball")
public class ComentarioFootballController {

    @Autowired
    private ComentarioFootballService comentarioFootballService;

    @Autowired
    private FootballContentService footballContentService;


    @PostMapping("/CrearComentarioFootabll/{nombreContenido}")
    public String createComentarioF1(@PathVariable String nombreContenido, @RequestParam String textoComentario, HttpSession session) {
        // Obtener el usuario de la sesión
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new RuntimeException("No user session found");
        }

        // Obtener la película por su nombre
        FootballContent footballContent = footballContentService.getFootballContentByNombrePartido(nombreContenido)
                .orElseThrow(() -> new RuntimeException("Pelicula not found"));

        //Obtener el nickname del usuario
        String nickname = user.getNickname();

        // Crear el comentario
        ComentarioFootball comentarioFootball = new ComentarioFootball();
        comentarioFootball.setTexto(textoComentario);
        comentarioFootball.setNickname(nickname);
        comentarioFootball.setFechaComentario();
        comentarioFootball.setUsuario(user);
        comentarioFootball.setFootballContent(footballContent);

        // Guardar el comentario
        comentarioFootballService.createComentarioFootballContent(comentarioFootball);

        // Redirigir a la página de detalles de la película
        return "redirect:/api/FootballContent/" + nombreContenido;
    }

}
