package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.*;
import com.example.cursospringboot.service.ComentarioFootballService;
import com.example.cursospringboot.service.FootballContentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //Para que sea un controlador rest de spring boot y no un controlador comun
@RequestMapping("/api/FootballContent") //Para que todas las rutas de este controlador empiecen con /api/F1
public class FootballContentController {


    @Autowired
    FootballContentService footballContentService;

    @Autowired
    ComentarioFootballService comentarioFootballService;

    @GetMapping("/")
    public String getAllFootballContent(Model model) {
        List<FootballContent> listaFootballContent = footballContentService.getAllFootballContent();
        model.addAttribute("listaFootballContent", listaFootballContent);
        return "indexFootball";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }


    @GetMapping("/{nombreFootballContent}")
    public String getNombreFootballContent(@PathVariable String nombreFootballContent, Model model, HttpSession session) {
        FootballContent footballContent = footballContentService.getFootballContentByNombrePartido(nombreFootballContent)
                .orElseThrow(() -> new RuntimeException("Contenido de Futbol not found"));
        model.addAttribute("footballContent", footballContent);
        User user = (User) session.getAttribute("user");
        if (user == null || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirige al usuario a la página de inicio de sesión si no está autenticado
        }
        // Fetch the list of comments for the specific movie
        List<ComentarioFootball> comentarios = comentarioFootballService.getAllComentariosByFootballContent(footballContent);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("session", user);
        return "indexDetalladoFootball";
    }

    @GetMapping("/search/realtime")
    @ResponseBody
    public List<FootballContent> realtimeSearch(@RequestParam String query) {
        return footballContentService.searchFootballContent(query);
    }


}
