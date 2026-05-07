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
 * Controlador encargado de la navegación pública por categorías y de las búsquedas de productos.
 * <p>
 * Gestiona las peticiones de los usuarios finales, permitiendo explorar el catálogo
 * de videojuegos filtrado por categorías o realizar búsquedas globales por título.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoryService;
    private final VideojuegoService gameService;

    /**
     * Constructor para la inyección de dependencias.
     * Al inyectar ambos servicios, el controlador puede relacionar datos de categorías con sus juegos.
     *
     * @param categoryService Servicio para la gestión de categorías.
     * @param gameService Servicio para la gestión de videojuegos.
     */
    public CategoriaController(CategoriaService categoryService, VideojuegoService gameService) {
        this.categoryService = categoryService;
        this.gameService = gameService;
    }

    /**
     * Proporciona la lista de todas las categorías a todos los métodos del controlador.
     * <p>
     * Al usar {@code @ModelAttribute}, Spring añade automáticamente el retorno de este método
     * al modelo de cualquier vista renderizada por este controlador. Es ideal para
     * rellenar menús de navegación laterales o desplegables.
     * </p>
     *
     * @return Lista completa de categorías registradas.
     */
    @ModelAttribute("todasLasCategorias")
    public List<Categoria> getTodasLasCategorias() {
        return categoryService.obtenerTodos();
    }

    /**
     * Muestra la página principal de categorías donde se listan todas las opciones disponibles.
     *
     * @param model Objeto para pasar la lista de categorías a la vista.
     * @return El nombre de la plantilla {@code categories/list}.
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("categorias", categoryService.obtenerTodos());
        return "categories/list";
    }

    /**
     * Muestra el detalle de una categoría y los videojuegos asociados a ella.
     * <p>
     * Los juegos recuperados se ordenan alfabéticamente por título de forma
     * insensible a mayúsculas antes de enviarlos a la vista.
     * </p>
     *
     * @param id Identificador de la categoría.
     * @param model Objeto para pasar la entidad categoría y la lista de juegos filtrada.
     * @return La vista de detalle {@code categories/detail}.
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Categoria categoria = categoryService.buscarPorId(id).orElse(null);
        List<Videojuego> listaJuegos = gameService.obtenerJuegosDeCategoria(id);
        
        if (listaJuegos != null) {
            listaJuegos.sort(Comparator.comparing(Videojuego::getTitulo, String.CASE_INSENSITIVE_ORDER));
        }

        model.addAttribute("categoria", categoria);
        model.addAttribute("listaJuegos", listaJuegos);
        return "categories/detail";
    }

    /**
     * Procesa las búsquedas de videojuegos por título.
     * <p>
     * Recibe un parámetro de consulta opcional y devuelve los juegos que coincidan,
     * ordenados alfabéticamente.
     * </p>
     *
     * @param query Término de búsqueda introducido por el usuario en el formulario.
     * @param model Objeto para pasar los resultados y mantener el término buscado en el input.
     * @return La vista de resultados {@code categories/search-results}.
     */
    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "query", required = false) String query, Model model) {
        List<Videojuego> resultados = gameService.buscarPorNombre(query);

        if (resultados != null) {
            resultados.sort(Comparator.comparing(Videojuego::getTitulo, String.CASE_INSENSITIVE_ORDER));
        }

        model.addAttribute("listaJuegos", resultados);
        model.addAttribute("query", query);
        return "categories/search-results";
    }
}