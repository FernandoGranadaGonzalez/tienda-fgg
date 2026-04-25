package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Game;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoryService;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoryController {

    private final CategoryService categoryService;
    private final GameService gameService;

    public CategoryController(CategoryService categoryService, GameService gameService) {
        this.categoryService = categoryService;
        this.gameService = gameService;
    }

    @ModelAttribute("todasLasCategorias")
    public List<Category> getTodasLasCategorias() {
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