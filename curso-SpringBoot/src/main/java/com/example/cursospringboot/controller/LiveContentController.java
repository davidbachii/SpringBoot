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
@RequestMapping("/api/LiveContent")
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


    @GetMapping("/agregarLiveContent")
    public String añadirLiveContent(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }
        return "agregarContenido";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }

    @PostMapping("/update/{nombreLiveContenido}")
    public String updateLiveContent(
                                    @PathVariable String nombreLiveContenido,
                                    @RequestParam String nombreContenido,
                                    @RequestParam String descripcion,
                                    @RequestParam String url_image,
                                    @RequestParam String url_video,
                                    @RequestParam LocalDateTime startTime,
                                    @RequestParam LocalDateTime endTime,
                                    @RequestParam String type,
                                    @RequestParam Integer anho,
                                    RedirectAttributes redirectAttributes) {
        try {


            LiveContent detallesLiveContent = new LiveContent();
            detallesLiveContent.setNombreContenido(nombreContenido);
            detallesLiveContent.setDescripcion(descripcion);
            detallesLiveContent.setUrl_image(url_image);
            detallesLiveContent.setUrl_video(url_video);
            detallesLiveContent.setStartTime(startTime);
            detallesLiveContent.setEndTime(endTime);
            detallesLiveContent.setType(type);
            detallesLiveContent.setAnho(anho);

            // Verificar que la hora de inicio no sea mayor que la hora de fin
            if (startTime.isAfter(endTime)) {
                redirectAttributes.addFlashAttribute("errorMessage", "La hora de inicio no puede ser mayor que la hora de fin.");
                return "redirect:/api/LiveContent";
            }

            List<LiveContent> allLiveContents = liveContentService.getAllLiveContents();
            for (LiveContent existingContent : allLiveContents) {
                if (!existingContent.getNombreContenido().equals(nombreLiveContenido) &&
                        ((existingContent.getStartTime().isBefore(endTime) && existingContent.getEndTime().isAfter(startTime)) ||
                                (existingContent.getStartTime().isBefore(startTime) && existingContent.getEndTime().isAfter(endTime)))) {
                    redirectAttributes.addFlashAttribute("errorMessage", "El horario del contenido en directo se superpone con otro contenido en directo existente.");
                    return "redirect:/api/LiveContent";
                }
            }


            liveContentService.updateLiveContent(nombreLiveContenido, detallesLiveContent);
            redirectAttributes.addFlashAttribute("successMessage", "Contenido en directo actualizado con éxito");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/api/LiveContent";
    }


    @PostMapping("/delete/{id}")
    public String deleteLiveContent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            liveContentService.deleteLiveContent(id);
            redirectAttributes.addFlashAttribute("successMessage", "Contenido en directo borrado con éxito");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/api/LiveContent";
    }

    @PostMapping("/create")
    public String createLiveContent(
            @RequestParam String nombreContenidoL,
            @RequestParam String descripcionL,
            @RequestParam String url_imageL,
            @RequestParam String url_videoL,
            @RequestParam LocalDateTime startTime,
            @RequestParam LocalDateTime endTime,
            @RequestParam String type,
            @RequestParam Integer anhoL,
            HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        try {
            LiveContent liveContentNew = new LiveContent();
            liveContentNew.setNombreContenido(nombreContenidoL);
            liveContentNew.setDescripcion(descripcionL);
            liveContentNew.setUrl_image(url_imageL);
            liveContentNew.setUrl_video(url_videoL);
            liveContentNew.setStartTime(startTime);
            liveContentNew.setEndTime(endTime);
            liveContentNew.setType(type);
            liveContentNew.setAnho(anhoL);


            // Verificar que la hora de inicio no sea mayor que la hora de fin
            if (startTime.isAfter(endTime)) {
                redirectAttributes.addFlashAttribute("errorMessage", "La hora de inicio no puede ser mayor que la hora de fin.");
                return "redirect:/api/LiveContent/agregarLiveContent";
            }

            List<LiveContent> allLiveContents = liveContentService.getAllLiveContents();
            for (LiveContent existingContent : allLiveContents) {
                if (!existingContent.getNombreContenido().equals(nombreContenidoL) &&
                        ((existingContent.getStartTime().isBefore(endTime) && existingContent.getEndTime().isAfter(startTime)) ||
                                (existingContent.getStartTime().isBefore(startTime) && existingContent.getEndTime().isAfter(endTime)))) {
                    redirectAttributes.addFlashAttribute("errorMessage", "El horario del contenido en directo se superpone con otro contenido en directo existente.");
                    return "redirect:/api/LiveContent/agregarLiveContent";
                }
            }





            liveContentService.createLiveContent(liveContentNew);
            redirectAttributes.addFlashAttribute("successMessage", "Contenido en directo creado con éxito");
            return "redirect:/api/LiveContent"; // Redirect to the main live content page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al crear el contenido en directo");
            return "redirect:/api/LiveContent/agregarLiveContent"; // Redirect back to the add live content page
        }
    }



}
