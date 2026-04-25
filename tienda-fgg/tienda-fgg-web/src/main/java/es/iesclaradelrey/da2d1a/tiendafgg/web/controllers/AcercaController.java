package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcercaController {

    @GetMapping("/sobre-nosotros")
    public String sobreNosotros() {
        return "about-us";
    }

    @GetMapping("/condiciones")
    public String condiciones() {
        return "legal/terms";
    }
}