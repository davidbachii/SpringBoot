package com.example.cursospringboot.controller;

import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> updateInfo(@ModelAttribute User updatedUser, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no autenticado");
        }
        if (updatedUser.getEmail() != null && !updatedUser.getEmail().equals(user.getEmail())) {
            if (userService.emailExists(updatedUser.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo electrónico ya existe");
            }
            user.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getNickname() != null && !updatedUser.getNickname().equals(user.getNickname())) {
            if (userService.nicknameExists(updatedUser.getNickname())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nickname ya existe");
            }
            user.setNickname(updatedUser.getNickname());
        }
        user.setNombre(updatedUser.getNombre());
        userService.updateUser(user.getEmail(), user);
        return ResponseEntity.status(HttpStatus.OK).body("Información actualizada con éxito");
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
