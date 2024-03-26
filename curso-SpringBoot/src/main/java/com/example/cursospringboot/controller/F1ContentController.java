package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.service.F1ContentService;
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


    @GetMapping("/")
    public String getAllF1Content(Model model) {
        List<F1Content> listaf1 = f1ContentService.getAllF1Content();
        model.addAttribute("listaf1", listaf1);
        return "indexF1";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }


    @GetMapping("/{nombreCarreraF1}")
    public String getNombreCarreraF1(@PathVariable String nombreCarreraF1, Model model) {
        F1Content f1Content = f1ContentService.getF1ContentByNombreCarrera(nombreCarreraF1)
                .orElseThrow(() -> new RuntimeException("Contenido de F1 not found"));
        model.addAttribute("f1Content", f1Content);
        return "indexDetalladoF1";
    }

    @GetMapping("/search/realtime")
    @ResponseBody
    public List<F1Content> realtimeSearch(@RequestParam String query) {
        return f1ContentService.searchF1Content(query);
    }



}
