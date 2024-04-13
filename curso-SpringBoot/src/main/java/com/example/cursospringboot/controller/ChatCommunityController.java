package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.ChatCommunity;
import com.example.cursospringboot.entity.ChatMessage;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.ChatCommunityService;
import com.example.cursospringboot.service.ChatMessageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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
        if (user == null) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        // Fetch the list of comments for the specific movie
        List<ChatCommunity> comunidades = chatCommunityService.getAllCommunities();
        model.addAttribute("comunidades", comunidades);

        // Fetch the community and the list of messages for the specific community
        String communityNameToUse = communityName.orElse("Comunidad de Formula 1");
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
        if (user == null) {
            return "redirect:/login";
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

}
