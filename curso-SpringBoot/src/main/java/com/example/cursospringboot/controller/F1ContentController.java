package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.ComentarioF1;
import com.example.cursospringboot.entity.ComentarioPelicula;
import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.ComentarioF1Service;
import com.example.cursospringboot.service.F1ContentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //Para que sea un controlador rest de spring boot y no un controlador comun
@RequestMapping("/api/F1") //Para que todas las rutas de este controlador empiecen con /api/F1
public class F1ContentController {


    @Autowired
    F1ContentService f1ContentService;

    @Autowired
    ComentarioF1Service comentarioF1Service;


    @GetMapping("/")
    public String getAllF1Content(Model model) {
        List<F1Content> listaf1 = f1ContentService.getAllF1Content();
        model.addAttribute("listaf1", listaf1);
        return "indexF1";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }


    @GetMapping("/{nombreCarreraF1}")
    public String getNombreCarreraF1(@PathVariable String nombreCarreraF1, Model model,  HttpSession session) {
        F1Content f1Content = f1ContentService.getF1ContentByNombreCarrera(nombreCarreraF1)
                .orElseThrow(() -> new RuntimeException("Contenido de F1 not found"));
        model.addAttribute("f1Content", f1Content);
        User user = (User) session.getAttribute("user");
        if (user == null || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirige al usuario a la página de inicio de sesión si no está autenticado
        }
        // Fetch the list of comments for the specific movie
        List<ComentarioF1> comentarios = comentarioF1Service.getAllComentariosByF1(f1Content);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("session", user);
        return "indexDetalladoF1";
    }

    @GetMapping("/search/realtime")
    @ResponseBody
    public List<F1Content> realtimeSearch(@RequestParam String query) {
        return f1ContentService.searchF1Content(query);
    }



}
