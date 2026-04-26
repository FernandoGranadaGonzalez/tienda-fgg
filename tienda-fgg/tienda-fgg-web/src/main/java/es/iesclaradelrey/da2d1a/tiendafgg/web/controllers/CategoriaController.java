package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoryService;
    private final VideojuegoService gameService;

    public CategoriaController(CategoriaService categoryService, VideojuegoService gameService) {
        this.categoryService = categoryService;
        this.gameService = gameService;
    }

    @ModelAttribute("todasLasCategorias")
    public List<Categoria> getTodasLasCategorias() {
        return categoryService.obtenerTodos();
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("categorias", categoryService.obtenerTodos());
        return "categories/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoryService.buscarPorId(id).orElse(null));
        model.addAttribute("listaJuegos", gameService.obtenerJuegosDeCategoria(id));
        return "categories/detail";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "query", required = false) String query, Model model) {
        model.addAttribute("listaJuegos", gameService.buscarPorNombre(query));
        model.addAttribute("query", query);
        return "categories/search-results";
    }
}