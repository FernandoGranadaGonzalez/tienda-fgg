package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}