package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * Controlador para la gestión de navegación y consultas de categorías y sus videojuegos.
 * <p>
 * Este controlador maneja todas las peticiones bajo la ruta base {@code /categorias}.
 * Coordina la obtención de datos mediante los servicios inyectados y los prepara
 * para ser renderizados en las vistas de Thymeleaf.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoryService;
    private final VideojuegoService gameService;

    /**
     * Constructor para la inyección de dependencias de los servicios necesarios.
     */
    public CategoriaController(CategoriaService categoryService, VideojuegoService gameService) {
        this.categoryService = categoryService;
        this.gameService = gameService;
    }

    /**
     * Asegura que todas las vistas gestionadas por este controlador tengan acceso
     * a la lista completa de categorías.
     *
     * @return Una lista con todas las categorías registradas en el sistema.
     */
    @ModelAttribute("todasLasCategorias")
    public List<Categoria> getTodasLasCategorias() {
        return categoryService.obtenerTodos();
    }

    /**
     * Lista todas las categorías disponibles.
     *
     * @param model Objeto para pasar datos a la vista.
     * @return El nombre de la vista de listado de categorías.
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("categorias", categoryService.obtenerTodos());
        return "categories/list";
    }

    /**
     * Muestra el detalle de una categoría específica y los juegos asociados a ella.
     *
     * @param id    Identificador de la categoría recibido desde la URL.
     * @param model Objeto para pasar la categoría encontrada y su lista de juegos.
     * @return El nombre de la vista de detalle de la categoría.
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Categoria categoria = categoryService.buscarPorId(id).orElse(null);
        List<Videojuego> listaJuegos = gameService.obtenerJuegosDeCategoria(id);

        // REQUISITO: Ordenación alfabética por título
        if (listaJuegos != null) {
            listaJuegos.sort(Comparator.comparing(Videojuego::getTitulo, String.CASE_INSENSITIVE_ORDER));
        }

        model.addAttribute("categoria", categoria);
        model.addAttribute("listaJuegos", listaJuegos);
        return "categories/detail";
    }

    /**
     * Realiza una búsqueda de videojuegos por título y muestra los resultados.
     *
     * @param query El término de búsqueda introducido por el usuario.
     * @param model Objeto para pasar los resultados encontrados y el término de búsqueda.
     * @return El nombre de la vista de resultados de búsqueda.
     */
    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "query", required = false) String query, Model model) {
        List<Videojuego> resultados = gameService.buscarPorNombre(query);

        // REQUISITO: Ordenación alfabética por título
        if (resultados != null) {
            resultados.sort(Comparator.comparing(Videojuego::getTitulo, String.CASE_INSENSITIVE_ORDER));
        }

        model.addAttribute("listaJuegos", resultados);
        model.addAttribute("query", query);
        return "categories/search-results";
    }
}