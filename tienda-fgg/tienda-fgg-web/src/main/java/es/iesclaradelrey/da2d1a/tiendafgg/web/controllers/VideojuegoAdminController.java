package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.MarcaService;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller("videojuegoAdminController")
@RequestMapping("/admin/productos")
public class VideojuegoAdminController {

    private final VideojuegoService videojuegoService;
    private final MarcaService marcaService;
    private final CategoriaService categoriaService;

    public VideojuegoAdminController(VideojuegoService videojuegoService, MarcaService marcaService, CategoriaService categoriaService) {
        this.videojuegoService = videojuegoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("elementos", videojuegoService.obtenerTodos());
        model.addAttribute("tipo", "productos");
        return "admin/videojuegos/listado";
    }

    @GetMapping("/new")
    public String formularioNuevo(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        model.addAttribute("marcas", marcaService.obtenerTodos());
        model.addAttribute("todasCategorias", categoriaService.obtenerTodos());
        return "admin/videojuegos/formulario";
    }

    @GetMapping("/{id}/edit")
    public String formularioEditar(@PathVariable("id") Long id, Model model) {
        Optional<Videojuego> videojuego = videojuegoService.buscarPorId(id);
        if (videojuego.isPresent()) {
            model.addAttribute("videojuego", videojuego.get());
            model.addAttribute("marcas", marcaService.obtenerTodos());
            model.addAttribute("todasCategorias", categoriaService.obtenerTodos());
            return "admin/videojuegos/formulario";
        }
        return "redirect:/admin/productos";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("videojuego") Videojuego videojuego, Model model) {
        try {
            videojuegoService.guardar(videojuego);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el videojuego: " + e.getMessage());
            model.addAttribute("marcas", marcaService.obtenerTodos());
            model.addAttribute("todasCategorias", categoriaService.obtenerTodos());
            return "admin/videojuegos/formulario";
        }
    }

    @GetMapping("/{id}/delete")
    public String confirmarBorrado(@PathVariable Long id, Model model) {
        videojuegoService.buscarPorId(id).ifPresent(v -> model.addAttribute("elemento", v));

        model.addAttribute("urlBorrar", "/admin/productos/" + id + "/delete");

        return "admin/confirmar-borrado";
    }

    @PostMapping("/{id}/delete")
    public String ejecutarBorrado(@PathVariable Long id, Model model) {
        try {
            videojuegoService.eliminar(id);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            model.addAttribute("error", "No se puede eliminar el producto: " + e.getMessage());
            videojuegoService.buscarPorId(id).ifPresent(v -> model.addAttribute("elemento", v));
            model.addAttribute("urlBorrar", "/admin/productos/" + id + "/delete");
            return "admin/confirmar-borrado";
        }
    }
}