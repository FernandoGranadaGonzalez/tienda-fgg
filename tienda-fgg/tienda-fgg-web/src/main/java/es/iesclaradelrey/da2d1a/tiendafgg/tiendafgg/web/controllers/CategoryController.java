package es.iesclaradelrey.da2d1a.tiendafgg.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoryController {

    private final CategoryService servicioCategorias;

    public CategoryController(CategoryService servicioCategorias) {
        this.servicioCategorias = servicioCategorias;
    }

    @GetMapping({"", "/"})
    public String listado(Model modelo) {
        modelo.addAttribute("listaCategorias", servicioCategorias.obtenerTodas());
        return "categories/list";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model modelo) {
        servicioCategorias.buscarPorId(id).ifPresent(category -> modelo.addAttribute("categoria", category));
        return "categories/detail";
    }
}