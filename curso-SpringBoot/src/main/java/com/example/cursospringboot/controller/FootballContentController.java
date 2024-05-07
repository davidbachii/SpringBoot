package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.*;
import com.example.cursospringboot.service.ComentarioFootballService;
import com.example.cursospringboot.service.FootballContentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller //Para que sea un controlador rest de spring boot y no un controlador comun
@RequestMapping("/api/FootballContent") //Para que todas las rutas de este controlador empiecen con /api/F1
public class FootballContentController {


    @Autowired
    FootballContentService footballContentService;

    @Autowired
    ComentarioFootballService comentarioFootballService;

    @GetMapping("/")
    public String getAllFootballContent(Model model, HttpSession session) {
        List<FootballContent> listaFootballContent = footballContentService.getAllFootballContent();
        model.addAttribute("listaFootballContent", listaFootballContent);
        User user = (User) session.getAttribute("user");

        if (user != null) {
            Set<Role> roles = user.getRoles();
            model.addAttribute("roles", roles.stream().map(Role::getName).collect(Collectors.toList()));
        }
        return "indexFootball";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }

    @GetMapping("/agregarPartido")
    public String agregarPartido(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }
        return "agregarContenido";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }


    @GetMapping("/{nombreFootballContent}")
    public String getNombreFootballContent(@PathVariable String nombreFootballContent, Model model, HttpSession session) {
        FootballContent footballContent = footballContentService.getFootballContentByNombrePartido(nombreFootballContent)
                .orElseThrow(() -> new RuntimeException("Contenido de Futbol not found"));
        model.addAttribute("footballContent", footballContent);
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        // Fetch the list of comments for the specific movie
        List<ComentarioFootball> comentarios = comentarioFootballService.getAllComentariosByFootballContent(footballContent);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("session", user);

        // Add the roles of the user to the model
        Set<Role> roles = user.getRoles();
        model.addAttribute("roles", roles.stream().map(Role::getName).collect(Collectors.toList()));

        return "indexDetalladoFootball";
    }


    @PostMapping("/update/{nombreFootballContent}")
    public String updateFootballContent(@PathVariable String nombreFootballContent,
                                        @RequestParam String nombreContenido,
                                        @RequestParam String descripcion,
                                        @RequestParam String url_image,
                                        @RequestParam String url_video,
                                        @RequestParam Integer anho,
                                        @RequestParam String estadio,
                                        @RequestParam String equipos,
                                        @RequestParam String competicion,
                                        @RequestParam Integer duracion,
                                        @RequestParam String jugadores,
                                        @RequestParam String otrosDatos,
                                        HttpSession session, RedirectAttributes redirectAttributes ) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        try {
            FootballContent detallesFootballContent = new FootballContent();
            detallesFootballContent.setNombreContenido(nombreContenido);
            detallesFootballContent.setDescripcion(descripcion);
            detallesFootballContent.setUrl_image(url_image);
            detallesFootballContent.setUrl_video(url_video);
            detallesFootballContent.setAnho(anho);
            detallesFootballContent.setEstadio(estadio);
            detallesFootballContent.setEquipos(equipos);
            detallesFootballContent.setCompeticion(competicion);
            detallesFootballContent.setDuracion(duracion);
            detallesFootballContent.setJugadores(jugadores);
            detallesFootballContent.setOtrosDatos(otrosDatos);
            footballContentService.updateFootballContent(nombreFootballContent, detallesFootballContent);
            redirectAttributes.addFlashAttribute("successMessage", "Partido actualizado con éxito");
            return "redirect:/api/FootballContent/" + nombreContenido; // Redirect to the updated Football content page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al actualizar el partido");
            return "redirect:/api/FootballContent/" + nombreContenido; // Redirect to the updated Football content page
        }
    }

    @PostMapping("/delete/{nombreFootballContent}")
    public String deleteFootballContent(@PathVariable String nombreFootballContent,
                                        @RequestParam String password,
                                        @RequestParam String confirmPassword,
                                        HttpSession session, RedirectAttributes redirectAttributes ) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        if (!password.equals(user.getContrasenha())) {
            redirectAttributes.addFlashAttribute("errorMessage", "La contraseña no coincide con la del usuario actual");
            return "redirect:/api/FootballContent/" + nombreFootballContent; // Redirect back to the Football content page
        }

        if (!password.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Las contraseñas no coinciden");
            return "redirect:/api/FootballContent/" + nombreFootballContent; // Redirect back to the Football content page
        }

        try {
            // Delete the comments of the Football content
            comentarioFootballService.deleteComentariosByFootballContent(nombreFootballContent);
            // Delete the Football content
            footballContentService.deleteFootballContent(nombreFootballContent);
            redirectAttributes.addFlashAttribute("successMessage", "Contenido de Futbol borrado con éxito");
            return "redirect:/api/FootballContent/"; // Redirect to the main Football content page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al borrar el contenido de Futbol");
            return "redirect:/api/FootballContent/" + nombreFootballContent; // Redirect back to the Football content page
        }
    }

    @GetMapping("/search/realtime")
    @ResponseBody
    public List<FootballContent> realtimeSearch(@RequestParam String query) {
        return footballContentService.searchFootballContent(query);
    }


    @PostMapping("/create")
    public String createFootballContent(
            @RequestParam String nombreContenido,
            @RequestParam String descripcion,
            @RequestParam String url_image,
            @RequestParam String url_video,
            @RequestParam Integer anho,
            @RequestParam String estadio,
            @RequestParam String equipos,
            @RequestParam String competicion,
            @RequestParam Integer duracion,
            @RequestParam String jugadores,
            @RequestParam String otrosDatos,
            HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        try {
            FootballContent footballContentNew = new FootballContent();
            footballContentNew.setNombreContenido(nombreContenido);
            footballContentNew.setDescripcion(descripcion);
            footballContentNew.setUrl_image(url_image);
            footballContentNew.setUrl_video(url_video);
            footballContentNew.setAnho(anho);
            footballContentNew.setEstadio(estadio);
            footballContentNew.setEquipos(equipos);
            footballContentNew.setCompeticion(competicion);
            footballContentNew.setDuracion(duracion);
            footballContentNew.setJugadores(jugadores);
            footballContentNew.setOtrosDatos(otrosDatos);
            footballContentService.createFootballContent(footballContentNew);
            redirectAttributes.addFlashAttribute("successMessage", "Partido creado con éxito");
            return "redirect:/api/FootballContent/"; // Redirect to the main football content page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al crear el partido");
            return "redirect:/api/FootballContent/agregarPartido"; // Redirect back to the add football content page
        }
    }


}
