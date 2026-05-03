package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.MarcaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador de administración para la gestión de marcas o fabricantes.
 * <p>
 * Permite realizar las operaciones de mantenimiento (CRUD) sobre las marcas
 * que proveen los videojuegos en la tienda.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller("marcaAdminController")
@RequestMapping("/admin/marcas")
public class MarcaAdminController {

    private final MarcaService marcaService;

    /**
     * Constructor para la inyección de dependencias del servicio de marcas.
     *
     * @param marcaService Servicio de lógica de negocio para marcas.
     */
    public MarcaAdminController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    /**
     * Muestra el listado de todas las marcas registradas en el panel administrativo.
     *
     * @param model Objeto para enviar la lista de marcas a la vista.
     * @return El nombre de la plantilla {@code admin/marcas/listado}.
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("elementos", marcaService.obtenerTodos());
        return "admin/marcas/listado";
    }

    /**
     * Prepara el formulario para la creación de una nueva marca.
     *
     * @param model Objeto para pasar una nueva instancia de {@link Marca} al formulario.
     * @return La plantilla {@code admin/marcas/formulario}.
     */
    @GetMapping("/new")
    public String formularioNuevo(Model model) {
        model.addAttribute("marca", new Marca());
        return "admin/marcas/formulario";
    }

    /**
     * Procesa la inserción o actualización de una marca.
     *
     * @param marca Objeto marca vinculado desde el formulario.
     * @param model Objeto para gestionar mensajes de error en caso de fallo.
     * @return Redirección al listado o vuelta al formulario si ocurre un error.
     */
    @PostMapping("/save")
    public String guardar(@ModelAttribute("marca") Marca marca, Model model) {
        try {
            marcaService.guardar(marca);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/marcas/formulario";
        }
    }

    /**
     * Carga los datos de una marca existente para su edición.
     *
     * @param id Identificador de la marca a editar.
     * @param model Objeto para pasar la marca encontrada a la vista.
     * @return La plantilla del formulario de edición.
     */
    @GetMapping("/{id}/edit")
    public String editar(@PathVariable Long id, Model model) {
        marcaService.buscarPorId(id).ifPresent(m -> model.addAttribute("marca", m));
        return "admin/marcas/formulario";
    }

    /**
     * Muestra la pantalla de confirmación antes de proceder al borrado.
     *
     * @param id Identificador de la marca.
     * @param model Objeto para pasar los datos de la marca y definir la URL de acción.
     * @return Plantilla genérica de confirmación de borrado.
     */
    @GetMapping("/{id}/delete")
    public String confirmarBorrado(@PathVariable Long id, Model model) {
        marcaService.buscarPorId(id).ifPresent(m -> model.addAttribute("elemento", m));
        model.addAttribute("urlBorrar", "/admin/marcas/" + id + "/delete");
        return "admin/confirmar-borrado";
    }

    /**
     * Ejecuta la eliminación física de la marca.
     * <p>
     * Captura excepciones si la marca no puede borrarse por tener videojuegos asociados
     * (restricción de clave foránea).
     * </p>
     *
     * @param id Identificador de la marca a eliminar.
     * @param model Objeto para enviar feedback de error a la vista.
     * @return Redirección al listado o vuelta a la pantalla de confirmación con error.
     */
    @PostMapping("/{id}/delete")
    public String ejecutarBorrado(@PathVariable Long id, Model model) {
        try {
            marcaService.eliminar(id);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            model.addAttribute("error", "No se puede eliminar: existen productos asociados.");
            return "admin/confirmar-borrado";
        }
    }
}