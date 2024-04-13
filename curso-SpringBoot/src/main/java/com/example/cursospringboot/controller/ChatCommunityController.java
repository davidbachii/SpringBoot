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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<ChatMessage> mensajesUser = chatMessageService.getMessagesByUserAndCommunity(user, community);
        List<ChatMessage> mensajesOthers = chatMessageService.getMessagesByOtherUsersAndCommunity(user, community);
        model.addAttribute("comunidadSeleccionada", community);
        model.addAttribute("mensajesUser", mensajesUser);
        model.addAttribute("mensajesOthers", mensajesOthers);
        model.addAttribute("user", user); // Add the user object to the model
        return "chat";
    }

}
