package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.ChatCommunity;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.ChatCommunityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/ChatCommunity")
public class ChatCommunityController {

    @Autowired
    private ChatCommunityService chatCommunityService;



    @GetMapping("/")
    public String showChatCommunity(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        // Fetch the list of comments for the specific movie
        List<ChatCommunity> comunidades = chatCommunityService.getAllCommunities();
        model.addAttribute("comunidades", comunidades);
        model.addAttribute("user", user); // Add the user object to the model
        return "userProfile";
    }
}
