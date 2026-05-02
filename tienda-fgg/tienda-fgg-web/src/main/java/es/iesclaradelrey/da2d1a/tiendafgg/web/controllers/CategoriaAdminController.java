package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller("categoriaAdminController")
@RequestMapping("/admin/categorias")
public class CategoriaAdminController {

    private final CategoriaService categoriaService;

    public CategoriaAdminController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("elementos", categoriaService.obtenerTodos());
        return "admin/categorias/listado";
    }

    @GetMapping("/new")
    public String formularioNuevo(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "admin/categorias/formulario";
    }

    @GetMapping("/{id}/edit")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.buscarPorId(id);
        if (categoria.isPresent()) {
            model.addAttribute("categoria", categoria.get());
            return "admin/categorias/formulario";
        }
        return "redirect:/admin/categorias";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("categoria") Categoria categoria, Model model) {
        try {
            categoriaService.guardar(categoria);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la categoría: " + e.getMessage());
            return "admin/categorias/formulario";
        }
    }

    @GetMapping("/{id}/delete")
    public String confirmarBorrado(@PathVariable Long id, Model model) {
        categoriaService.buscarPorId(id).ifPresent(c -> model.addAttribute("elemento", c));
        model.addAttribute("urlBorrar", "/admin/categorias/" + id + "/delete");
        return "admin/confirmar-borrado";
    }

    @PostMapping("/{id}/delete")
    public String ejecutarBorrado(@PathVariable Long id, Model model) {
        try {
            categoriaService.eliminar(id);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            model.addAttribute("error", "No se puede eliminar la categoría: existen productos vinculados.");
            categoriaService.buscarPorId(id).ifPresent(c -> model.addAttribute("elemento", c));
            model.addAttribute("urlBorrar", "/admin/categorias/" + id + "/delete");
            return "admin/confirmar-borrado";
        }
    }
}