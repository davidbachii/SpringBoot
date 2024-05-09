package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.LiveContent;
import com.example.cursospringboot.entity.Role;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.LiveContentServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/LiveContent/")
public class LiveContentController {

    @Autowired
    LiveContentServiceImp liveContentService;

    @GetMapping
    public String getLiveContent(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }


        if (user.getPlanSuscripcion().equals("Gratis") || user.getPlanSuscripcion().equals("Basico")) {
            redirectAttributes.addFlashAttribute("errorMessage", "Actualiza tu plan de suscripción para acceder a este contenido");
            return "redirect:/api/userProfile/";
        }

        if (user != null) {
            Set<Role> roles = user.getRoles();
            model.addAttribute("roles", roles.stream().map(Role::getName).collect(Collectors.toList()));
        }


        List<LiveContent> liveContentsAll = liveContentService.getAllLiveContents();
        model.addAttribute("liveContents", liveContentsAll);

        // Lógica para obtener el contenido en directo que coincide con la hora actual
        LiveContent liveContent = liveContentService.getCurrentLiveContent();
        model.addAttribute("liveContentLive", liveContent);

        List<LiveContent> futureLiveContents = liveContentService.getFutureLiveContents();
        model.addAttribute("futureLiveContents", futureLiveContents);


        return "liveContent";
    }


    @PostMapping("/update/{nombreContenido}")
    public String updateLiveContent(@PathVariable String nombreContenido,
                                    @RequestParam String descripcion,
                                    @RequestParam String url_image,
                                    @RequestParam String url_video,
                                    @RequestParam LocalDateTime startTime,
                                    @RequestParam LocalDateTime endTime,
                                    @RequestParam String type,
                                    @RequestParam Integer anho,
                                    RedirectAttributes redirectAttributes) {
        LiveContent liveContent = new LiveContent();
        liveContent.setNombreContenido(nombreContenido);
        liveContent.setDescripcion(descripcion);
        liveContent.setUrl_image(url_image);
        liveContent.setUrl_video(url_video);
        liveContent.setStartTime(startTime);
        liveContent.setEndTime(endTime);
        liveContent.setType(type);
        liveContent.setAnho(anho);

        if (liveContentService.existsOverlappingLiveContents(startTime, endTime)) {
            redirectAttributes.addFlashAttribute("errorMessage", "El horario del contenido en directo se superpone con otro contenido en directo existente.");
            return "redirect:/api/LiveContent/";
        }

        try {
            liveContentService.updateLiveContent(liveContent);
            redirectAttributes.addFlashAttribute("successMessage", "Contenido en directo actualizado con éxito");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/api/LiveContent/";
    }
}
