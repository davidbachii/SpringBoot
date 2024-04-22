package com.example.cursospringboot.controller;


import com.example.cursospringboot.entity.TarjetaCredito;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.service.TarjetaService;
import com.example.cursospringboot.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller // Esto es para que sea un controlador de spring boot
@RequestMapping("/api/pago") //Para que todas las rutas de este controlador empiecen con /api/pago
public class TarjetaCreditoController {


    @Autowired
    private TarjetaService tarjetaCreditoService;


    @Autowired
    private UserService userService;


    @PostMapping("/ProcesarPagoServlet")
    public RedirectView procesarPago(@RequestParam("titular") String titular,
                                     @RequestParam("numeroT") String numeroTarjeta,
                                     @RequestParam("fechaCaducidad") String fechaCaducidad,
                                     @RequestParam("codigoSeguridad") String codigoSeguridad, HttpSession session) {


        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new RedirectView("/api/users/");
        }

        TarjetaCredito tj = new TarjetaCredito();
        tj.setTitular(titular);
        tj.setNumeroT(numeroTarjeta);
        tj.setFechaCaducidad(fechaCaducidad);
        tj.setCodigoSeguridad(codigoSeguridad);
        tj.setUser(user);

        //Si se ha podido crear la tarjeta se valida el pago del usuario
        if (user.getPagoValidado().equals(false)) {
            tarjetaCreditoService.createTarjeta(tj);
            user.setPagoValidado(true);
            userService.updateUser(user.getEmail(), user);

        }


        session.invalidate();

        return new RedirectView("/api/users/");
    }


    @GetMapping("/")
    public String root(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "login";
        }

        return "tarjetaCredito";
    }


}
