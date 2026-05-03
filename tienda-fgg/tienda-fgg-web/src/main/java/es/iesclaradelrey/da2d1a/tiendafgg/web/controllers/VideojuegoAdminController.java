package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.MarcaService;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador de administración para la gestión integral de Videojuegos (Productos).
 * <p>
 * Gestiona el ciclo de vida completo de los videojuegos en el panel administrativo,
 * incluyendo la validación de datos de entrada y la gestión de relaciones con
 * marcas y categorías.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller("videojuegoAdminController")
@RequestMapping("/admin/productos")
public class VideojuegoAdminController {

    private final VideojuegoService videojuegoService;
    private final MarcaService marcaService;
    private final CategoriaService categoriaService;

    /**
     * Constructor con inyección de múltiples servicios.
     * <p>
     * Se requiere acceso a {@link MarcaService} y {@link CategoriaService} para
     * poder poblar los selectores dinámicos en los formularios de creación y edición.
     * </p>
     */
    public VideojuegoAdminController(VideojuegoService videojuegoService,
                                     MarcaService marcaService,
                                     CategoriaService categoriaService) {
        this.videojuegoService = videojuegoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
    }

    /**
     * Muestra el listado de todos los videojuegos en el panel de gestión.
     *
     * @param model Objeto para enviar la lista de productos y metadatos a la vista.
     * @return El nombre de la plantilla {@code admin/videojuegos/listado}.
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("elementos", videojuegoService.obtenerTodos());
        model.addAttribute("tipo", "productos");
        return "admin/videojuegos/listado";
    }

    /**
     * Muestra el formulario para registrar un nuevo videojuego.
     * <p>
     * Carga en el modelo las listas de marcas y categorías existentes para permitir
     * al usuario seleccionarlas mediante componentes de interfaz.
     * </p>
     *
     * @param model Objeto para inicializar el formulario con un objeto vacío y datos maestros.
     * @return La plantilla {@code admin/videojuegos/formulario}.
     */
    @GetMapping("/new")
    public String formularioNuevo(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        model.addAttribute("marcas", marcaService.obtenerTodos());
        model.addAttribute("todasCategorias", categoriaService.obtenerTodos());
        return "admin/videojuegos/formulario";
    }

    /**
     * Muestra el formulario de edición para un videojuego existente.
     *
     * @param id Identificador del videojuego a editar.
     * @param model Objeto para cargar los datos del juego y las listas de selección.
     * @return El formulario de edición o redirección al listado si el ID no es válido.
     */
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

    /**
     * Procesa la persistencia de un videojuego tras validar los datos.
     * <p>
     * Utiliza {@code @Valid} para activar las restricciones definidas en la entidad.
     * Gestiona específicamente errores de integridad (como títulos duplicados) y
     * asegura que, en caso de error, el formulario recupere las listas de marcas y categorías.
     * </p>
     *
     * @param videojuego Objeto capturado del formulario.
     * @param result Resultado de la validación automática.
     * @param model Objeto para manejar errores y datos maestros.
     * @return Redirección al listado en éxito o vuelta al formulario con mensajes de error.
     */
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute("videojuego") Videojuego videojuego,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("marcas", marcaService.obtenerTodos());
            model.addAttribute("todasCategorias", categoriaService.obtenerTodos());
            return "admin/videojuegos/formulario";
        }

        try {
            videojuegoService.guardar(videojuego);
            return "redirect:/admin/productos";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Ya existe un videojuego con ese título.");
            model.addAttribute("marcas", marcaService.obtenerTodos());
            model.addAttribute("todasCategorias", categoriaService.obtenerTodos());
            return "admin/videojuegos/formulario";
        } catch (Exception e) {
            model.addAttribute("error", "Error inesperado: " + e.getMessage());
            model.addAttribute("marcas", marcaService.obtenerTodos());
            model.addAttribute("todasCategorias", categoriaService.obtenerTodos());
            return "admin/videojuegos/formulario";
        }
    }

    /**
     * Muestra la vista de confirmación de borrado para un producto.
     *
     * @param id Identificador del producto.
     * @param model Objeto para pasar la información del elemento a eliminar.
     * @return Plantilla de confirmación.
     */
    @GetMapping("/{id}/delete")
    public String confirmarBorrado(@PathVariable Long id, Model model) {
        videojuegoService.buscarPorId(id).ifPresent(v -> model.addAttribute("elemento", v));
        model.addAttribute("urlBorrar", "/admin/productos/" + id + "/delete");
        return "admin/confirmar-borrado";
    }

    /**
     * Realiza la eliminación física del videojuego en la base de datos.
     *
     * @param id Identificador del producto a suprimir.
     * @param model Objeto para devolver mensajes de error en caso de fallo.
     * @return Redirección al listado o vuelta a confirmación si hay errores de base de datos.
     */
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