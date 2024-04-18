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
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login"; // Redirige a la página de inicio de sesión si el usuario no está autenticado
        }

        // Lógica para obtener el contenido en directo que coincide con la hora actual
        LiveContent liveContent = liveContentService.getCurrentLiveContent();

        // Añade el contenido al modelo
        model.addAttribute("liveContent", liveContent);

            List<LiveContent> futureLiveContents = liveContentService.getFutureLiveContents();
            model.addAttribute("futureLiveContents", futureLiveContents);


        return "liveContent";
    }

}
