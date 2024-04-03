package com.example.cursospringboot.controller;

import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/userProfile")
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showProfile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        if (user == null || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirige al usuario a la página de inicio de sesión si no está autenticado
        }
        return "userProfile";
    }

    @PostMapping("/updateInfo")
    public String updateInfo(@ModelAttribute User updatedUser, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setNombre(updatedUser.getNombre());
        user.setNickname(updatedUser.getNickname());
        user.setEmail(updatedUser.getEmail());
        userService.updateUser(user.getEmail(), user);
        return "redirect:/userProfile";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam String password_current, @RequestParam String password_1, @RequestParam String password_2, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (userService.authenticateUser(user.getEmail(), password_current) && password_1.equals(password_2)) {
            user.setContrasenha(password_1);
            userService.updateUser(user.getEmail(), user);
        }
        return "redirect:/userProfile";
    }

    @PostMapping("/updatePlan")
    public String updatePlan(@RequestParam String account_planSuscripcion, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setPlanSuscripcion(account_planSuscripcion);
        userService.updateUser(user.getEmail(), user);
        return "redirect:/userProfile";
    }
}
