package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.LiveContent;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.LiveContentServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/LiveContent/")
public class LiveContentController {

    @Autowired
    LiveContentServiceImp liveContentService;

    @GetMapping
    public String getLiveContent(Model model, HttpSession session) {
        // Comprueba si el usuario está autenticado
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // Si el usuario no está autenticado, redirige a la página de inicio de sesión
            return "login";
        }

        // Obtén todos los contenidos en directo
        List<LiveContent> allLiveContents = liveContentService.getAllLiveContents();

        // Añade todos los contenidos en directo al modelo
        model.addAttribute("liveContent", allLiveContents);

        return "liveContent";
    }
}
