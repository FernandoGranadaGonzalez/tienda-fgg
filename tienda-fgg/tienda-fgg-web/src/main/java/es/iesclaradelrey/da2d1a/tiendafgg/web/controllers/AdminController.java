package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/admin";
    }

    @GetMapping("/videojuegos/")
    public String redirectVideojuegos() {
        return "redirect:/admin/productos";
    }

    @GetMapping("/categorias/")
    public String redirectCategorias() {
        return "redirect:/admin/categorias";
    }

    @GetMapping("/marcas/")
    public String redirectMarcas() {
        return "redirect:/admin/marcas";
    }
}