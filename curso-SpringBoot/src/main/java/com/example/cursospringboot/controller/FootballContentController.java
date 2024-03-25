package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.FootballContent;
import com.example.cursospringboot.service.FootballContentService;
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

    @GetMapping("/")
    public String getAllFootballContent(Model model) {
        List<FootballContent> listaFootballContent = footballContentService.getAllFootballContent();
        model.addAttribute("listaFootballContent", listaFootballContent);
        return "index";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }


    @GetMapping("/{nombreCarreraF1}")
    public String getNombreFootballContent(@PathVariable String nombrePartido, Model model) {
        FootballContent footballContent = footballContentService.getFootballContentByNombrePartido(nombrePartido)
                .orElseThrow(() -> new RuntimeException("Contenido de Futbol not found"));
        model.addAttribute("footballContent", footballContent);
        return "indexDetallado";
    }

    @GetMapping("/search/realtime")
    @ResponseBody
    public List<FootballContent> realtimeSearch(@RequestParam String query) {
        return footballContentService.searchFootballContent(query);
    }


}
