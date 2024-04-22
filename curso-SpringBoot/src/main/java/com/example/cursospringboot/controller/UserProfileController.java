package com.example.cursospringboot.controller;

import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api/userProfile")
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showProfile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        model.addAttribute("user", user); // Add the user object to the model
        return "userProfile";
    }

    @GetMapping("/updateProfilePicture")
    public String updateProfilePicture(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        return "profileImage";
    }

    @PostMapping("/updateInfo")
    public String updateInfo(@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos, @RequestParam("nickname") String nickname, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        if (nickname != null && !nickname.equals(user.getNickname())) {
            if (userService.nicknameExists(nickname)) {
                redirectAttributes.addFlashAttribute("errorMessage", "El nickname ya está en uso");
                return "redirect:/api/userProfile/";
            }
            user.setNickname(nickname);
        }
        user.setNombre(nombre);
        user.setApellidos(apellidos);
        try {
            userService.updateUser(user.getEmail(), user);
            redirectAttributes.addFlashAttribute("successMessage", "Información actualizada con éxito");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al actualizar la información");
        }
        return "redirect:/api/userProfile/";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam String password_current, @RequestParam String password_1, @RequestParam String password_2, HttpSession session, RedirectAttributes redirectAttributes ) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        else if (password_current.trim().isEmpty() || password_1.trim().isEmpty() || password_2.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Por favor complete todos los campos de contraseña");
            return "redirect:/api/userProfile/";
        }
        else if (!userService.authenticateUser(user.getEmail(), password_current)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Contraseña actual incorrecta");
            return "redirect:/api/userProfile/";
        }
        else if (!password_1.equals(password_2)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Las contraseñas no coinciden");
            return "redirect:/api/userProfile/";
        }
        else {
            user.setContrasenha(password_1);
            userService.updateUser(user.getEmail(), user);
            redirectAttributes.addFlashAttribute("successMessage", "Contraseña actualizada con éxito");
            return "redirect:/api/userProfile/";
        }
    }

    @GetMapping("/selectProfilePicture/{imageName}")
    public String selectProfilePicture(@PathVariable String imageName, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getPagoValidado().equals(false) || "Sin Plan".equals(user.getPlanSuscripcion())) {
            return "login"; // Redirect the user to the login page if not authenticated
        }
        user.setUrl_image_perfil("/images/Perfil/" + imageName);
        try {
            userService.updateUser(user.getEmail(), user);
            redirectAttributes.addFlashAttribute("successMessage", "Imagen de perfil actualizada con éxito");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al actualizar la imagen de perfil");
        }
        return "redirect:/api/userProfile/";
    }

}
