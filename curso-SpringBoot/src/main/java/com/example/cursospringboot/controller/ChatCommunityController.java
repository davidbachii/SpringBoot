package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.*;
import com.example.cursospringboot.service.ChatCommunityService;
import com.example.cursospringboot.service.ChatMessageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/ChatCommunity")
public class ChatCommunityController {

    @Autowired
    private ChatCommunityService chatCommunityService;

    @Autowired
    private ChatMessageService chatMessageService;



    @GetMapping({"/", "/{communityName}"})
    public String showChatCommunity(@PathVariable Optional<String> communityName, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false)) {
            return "login"; // Redirect the user to the login page if not authenticated
        }

        if (user != null) {
            Set<Role> roles = user.getRoles();
            model.addAttribute("roles", roles.stream().map(Role::getName).collect(Collectors.toList()));
        }

        // Fetch the list of comments for the specific movie
        List<ChatCommunity> comunidades = chatCommunityService.getAllCommunities();
        model.addAttribute("comunidades", comunidades);


        //Selecciona una comunidad aleatoria
        String nombreAleatorio = comunidades.get((int) (Math.random() * comunidades.size())).getNombreComunidad();


        // Fetch the community and the list of messages for the specific community
        String communityNameToUse = communityName.orElse(nombreAleatorio);
        ChatCommunity community = chatCommunityService.getCommunityByName(communityNameToUse);
        List<ChatMessage> allMessages = chatMessageService.getMessagesByCommunity(community);
        model.addAttribute("comunidadSeleccionada", community);
        model.addAttribute("AllMessages", allMessages);
        model.addAttribute("user", user); // Add the user object to the model
        return "chat";
    }



    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam("content") String content, @RequestParam("communityName") String communityName, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        ChatCommunity community = chatCommunityService.getCommunityByName(communityName);
        if (community == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Comunidad no encontrada");
            return "redirect:/api/ChatCommunity/";
        }
        try {
            ChatMessage newMessage = new ChatMessage();
            newMessage.setMessage(content);
            newMessage.setSentBy(user);
            newMessage.setCommunity(community);
            newMessage.setSentDate();
            newMessage.setHoraEnvio();
            chatMessageService.createMessage(newMessage);
            redirectAttributes.addFlashAttribute("successMessage", "Mensaje enviado con éxito");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al enviar el mensaje: " + e.getMessage());
        }
        return "redirect:/api/ChatCommunity/" + communityName;
    }

    @PostMapping("/create")
    public String createComunidad(
            @RequestParam String nombreComunidad,
            @RequestParam String descripcionComunidad,
            @RequestParam String url_imageComunidad,
            @RequestParam LocalDate fechaCreacion,
            HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN")))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        try {
            ChatCommunity community = new ChatCommunity();
            community.setNombreComunidad(nombreComunidad);
            community.setDescripcion(descripcionComunidad);
            community.setFechaCreacion(fechaCreacion);
            community.setCreatedBy(user);
            community.setUrl_image(url_imageComunidad);

            chatCommunityService.createCommunity(community);
            redirectAttributes.addFlashAttribute("successMessage", "Comunidad creada con éxito");
            return "redirect:/api/ChatCommunity/"; // Redirect to the main movie page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al crear la comunidad");
            return "redirect:/api/ChatCommunity/"; // Redirect back to the add movie page
        }
    }


    @PostMapping("/update/{nombreComunidad}")
    public String updateComunidad(@PathVariable String nombreComunidad,
                                  @RequestParam String nombreComunidadUpdate,
                                  @RequestParam String descripcionComunidadUpdate,
                                  @RequestParam String url_imageComunidadUpdate,
                                  @RequestParam LocalDate fechaCreacionUpdate,
                                  HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().map(Role::getName).collect(Collectors.toList()).contains("ADMIN"))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        try {
            // Obtén la comunidad existente
            ChatCommunity existingCommunity = chatCommunityService.getCommunityByName(nombreComunidad);
            if (existingCommunity == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "Comunidad no encontrada");
                return "redirect:/api/ChatCommunity/";
            }

            // Actualiza los campos necesarios
            existingCommunity.setDescripcion(descripcionComunidadUpdate);
            existingCommunity.setUrl_image(url_imageComunidadUpdate);
            existingCommunity.setFechaCreacion(fechaCreacionUpdate);
            existingCommunity.setNombreComunidad(nombreComunidadUpdate);

            // Guarda la comunidad actualizada
            chatCommunityService.updateComunidad(nombreComunidad, existingCommunity);
            redirectAttributes.addFlashAttribute("successMessage", "Comunidad actualizada con éxito");
            return "redirect:/api/ChatCommunity/" + nombreComunidadUpdate; // Redirect to the updated community page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al actualizar la comunidad");
            return "redirect:/api/ChatCommunity/" + nombreComunidadUpdate; // Redirect back to the community page
        }
    }

    @PostMapping("/delete/{nombreComunidad}")
    public String deleteComunidad(@PathVariable String nombreComunidad,
                                  @RequestParam String password,
                                  @RequestParam String confirmPassword,
                                  HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || (!user.getRoles().stream().map(Role::getName).collect(Collectors.toList()).contains("ADMIN"))) {
            return "login"; // Redirect the user to the login page if not authenticated or not an admin
        }

        if (!password.equals(user.getContrasenha())) {
            redirectAttributes.addFlashAttribute("errorMessage", "La contraseña no coincide con la del usuario actual");
            return "redirect:/api/ChatCommunity/"; // Redirect back to the movie page
        }

        if (!password.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Las contraseñas no coinciden");
            return "redirect:/api/ChatCommunity/"; // Redirect back to the movie page
        }

        try {

            // Implementar la lógica para borrar la comunidad por su nombre
            chatCommunityService.deleteCommunity(nombreComunidad);
            redirectAttributes.addFlashAttribute("successMessage", "Comunidad borrada con éxito");
            return "redirect:/api/ChatCommunity/"; // Redirect to the main community page
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al borrar la comunidad");
            return "redirect:/api/ChatCommunity/" + nombreComunidad; // Redirect back to the community page
        }
    }

}
