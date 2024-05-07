package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.*;
import com.example.cursospringboot.service.ComentarioF1Service;
import com.example.cursospringboot.service.F1ContentService;
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
@RequestMapping("/api/F1") //Para que todas las rutas de este controlador empiecen con /api/F1
public class F1ContentController {


    @Autowired
    F1ContentService f1ContentService;

    @Autowired
    ComentarioF1Service comentarioF1Service;


    @GetMapping("/")
    public String getAllF1Content(Model model, HttpSession session) {
        List<F1Content> listaf1 = f1ContentService.getAllF1Content();
        model.addAttribute("listaf1", listaf1);
        User user = (User) session.getAttribute("user");

        if (user != null) {
            Set<Role> roles = user.getRoles();
            model.addAttribute("roles", roles.stream().map(Role::getName).collect(Collectors.toList()));
        }

        return "indexF1";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }

    @GetMapping("/añadirCarrera")
    public String añadirCarrera(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }
        return "agregarContenido";  // nombre de tu archivo Thymeleaf sin la extensión .html
    }


    @GetMapping("/{nombreCarreraF1}")
    public String getNombreCarreraF1(@PathVariable String nombreCarreraF1, Model model,  HttpSession session) {
        F1Content f1Content = f1ContentService.getF1ContentByNombreCarrera(nombreCarreraF1)
                .orElseThrow(() -> new RuntimeException("Contenido de F1 not found"));
        model.addAttribute("f1Content", f1Content);
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        // Fetch the list of comments for the specific movie
        List<ComentarioF1> comentarios = comentarioF1Service.getAllComentariosByF1(f1Content);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("session", user);

        // Add the roles of the user to the model
        Set<Role> roles = user.getRoles();
        model.addAttribute("roles", roles.stream().map(Role::getName).collect(Collectors.toList()));
        return "indexDetalladoF1";
    }

    @PostMapping("/update/{nombreCarreraF1}")
    public String updateF1Content(@PathVariable String nombreCarreraF1,
                                  @RequestParam String nombreContenido,
                                  @RequestParam String descripcion,
                                  @RequestParam String url_image,
                                  @RequestParam String url_video,
                                  @RequestParam Integer anho,
                                  @RequestParam String circuito,
                                  @RequestParam String equipos,
                                  @RequestParam String nacionalidad,
                                  @RequestParam Integer duracion,
                                  @RequestParam String pilotos,
                                  @RequestParam String otrosDatos,
                                  HttpSession session, RedirectAttributes redirectAttributes ) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        try {
            F1Content detallesF1Content = new F1Content();
            detallesF1Content.setNombreContenido(nombreContenido);
            detallesF1Content.setDescripcion(descripcion);
            detallesF1Content.setUrl_image(url_image);
            detallesF1Content.setUrl_video(url_video);
            detallesF1Content.setAnho(anho);
            detallesF1Content.setCircuito(circuito);
            detallesF1Content.setEquipos(equipos);
            detallesF1Content.setNacionalidad(nacionalidad);
            detallesF1Content.setDuracion(duracion);
            detallesF1Content.setPilotos(pilotos);
            detallesF1Content.setOtrosDatos(otrosDatos);
            f1ContentService.updateF1Content(nombreCarreraF1, detallesF1Content);
            redirectAttributes.addFlashAttribute("successMessage", "Carrera actualizada con éxito");
            return "redirect:/api/F1/" + nombreContenido; // Redirect to the updated F1 content page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al actualizar la carrera");
            return "redirect:/api/F1/" + nombreContenido; // Redirect to the updated F1 content page
        }
    }

    @PostMapping("/create")
    public String createF1Content(
            @RequestParam String nombreContenidoF1,
            @RequestParam String descripcionF1,
            @RequestParam String url_imageF1,
            @RequestParam String url_videoF1,
            @RequestParam Integer anhoF1,
            @RequestParam String circuitoF1,
            @RequestParam String equiposF1,
            @RequestParam String nacionalidadF1,
            @RequestParam Integer duracionF1,
            @RequestParam String pilotos,
            @RequestParam String otrosDatosF1,
            HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        try {
            F1Content f1New = new F1Content();
            f1New.setNombreContenido(nombreContenidoF1);
            f1New.setDescripcion(descripcionF1);
            f1New.setUrl_image(url_imageF1);
            f1New.setUrl_video(url_videoF1);
            f1New.setAnho(anhoF1);
            f1New.setCircuito(circuitoF1);
            f1New.setEquipos(equiposF1);
            f1New.setNacionalidad(nacionalidadF1);
            f1New.setDuracion(duracionF1);
            f1New.setPilotos(pilotos);
            f1New.setOtrosDatos(otrosDatosF1);
            f1ContentService.createF1Content(f1New);
            redirectAttributes.addFlashAttribute("successMessage", "Carrera creada con éxito");
            return "redirect:/api/F1/"; // Redirect to the main F1 content page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al crear la carrera");
            return "redirect:/api/F1/añadirCarrera"; // Redirect back to the add F1 content page
        }
    }

    @PostMapping("/delete/{nombreCarreraF1}")
    public String deletePelicula(@PathVariable String nombreCarreraF1,
                                 @RequestParam String password,
                                 @RequestParam String confirmPassword,
                                 HttpSession session, RedirectAttributes redirectAttributes ) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        if (!password.equals(user.getContrasenha())) {
            redirectAttributes.addFlashAttribute("errorMessage", "La contraseña no coincide con la del usuario actual");
            return "redirect:/api/F1/" + nombreCarreraF1; // Redirect back to the movie page
        }

        if (!password.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Las contraseñas no coinciden");
            return "redirect:/api/F1/" + nombreCarreraF1; // Redirect back to the movie page
        }

        try {
            // Delete the comments of the movie
            comentarioF1Service.deleteComentariosByF1Content(nombreCarreraF1);
            // Delete the movie
            f1ContentService.deleteF1Content(nombreCarreraF1);
            redirectAttributes.addFlashAttribute("successMessage", "Carrera borrada con éxito");
            return "redirect:/api/F1/"; // Redirect to the main movie page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al borrar la carrera");
            return "redirect:/api/F1/" + nombreCarreraF1; // Redirect back to the movie page
        }
    }

    @GetMapping("/search/realtime")
    @ResponseBody
    public List<F1Content> realtimeSearch(@RequestParam String query) {
        return f1ContentService.searchF1Content(query);
    }



}
