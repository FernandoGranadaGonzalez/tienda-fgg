package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Controlador público para la visualización de videojuegos.
 * <p>
 * Gestiona la exposición del catálogo general a los usuarios finales y el acceso
 * detallado a la ficha de cada producto.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
@RequestMapping("/productos")
public class VideojuegoController {

    private final VideojuegoService videojuegoService;

    /**
     * Constructor para la inyección de dependencias del servicio de videojuegos.
     *
     * @param videojuegoService Servicio encargado de la lógica de negocio de productos.
     */
    public VideojuegoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    /**
     * Recupera y muestra el listado completo de videojuegos disponibles en la tienda.
     * <p>
     * Los productos se presentan ordenados alfabéticamente por título, ignorando
     * diferencias entre mayúsculas y minúsculas.
     * </p>
     *
     * @param model Objeto para suministrar la lista de videojuegos a la vista.
     * @return El nombre de la plantilla de listado {@code productos/listado}.
     */
    @GetMapping
    public String listarProductos(Model model) {
        List<Videojuego> videojuegos = videojuegoService.obtenerTodos();

        if (videojuegos != null) {
            videojuegos.sort(Comparator.comparing(Videojuego::getTitulo, String.CASE_INSENSITIVE_ORDER));
        }

        model.addAttribute("videojuegos", videojuegos);
        return "productos/listado";
    }

    /**
     * Muestra la ficha detallada de un videojuego específico.
     * <p>
     * Utiliza una URL compuesta por el ID y un nombre escapado (slug) para
     * mejorar el posicionamiento en buscadores (SEO). Si el ID no corresponde
     * a ningún juego, el usuario es redirigido al catálogo general.
     * </p>
     *
     * @param id             Identificador único del videojuego.
     * @param model          Objeto para suministrar los datos del videojuego a la vista.
     * @return La plantilla {@code productos/detalle} o redirección en caso de no existir.
     */
    @GetMapping("/{id}/{nombreEscapado}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        Optional<Videojuego> videojuegoOptional = videojuegoService.buscarPorId(id);

        if (videojuegoOptional.isPresent()) {
            model.addAttribute("juego", videojuegoOptional.get());
            return "productos/detalle";
        } else {
            return "redirect:/productos";
        }
    }
}