package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador de administración para la gestión de categorías.
 * <p>
 * Proporciona las funcionalidades necesarias para listar, crear, editar y eliminar
 * categorías del sistema a través de una interfaz web.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller("categoriaAdminController")
@RequestMapping("/admin/categorias")
public class CategoriaAdminController {

    private final CategoriaService categoriaService;

    /**
     * Constructor para la inyección del servicio de categorías.
     *
     * @param categoriaService Servicio de lógica de negocio para categorías.
     */
    public CategoriaAdminController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Muestra el listado completo de categorías en el panel de administración.
     *
     * @param model Objeto para pasar datos a la vista.
     * @return El nombre de la plantilla de listado.
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("elementos", categoriaService.obtenerTodos());
        return "admin/categorias/listado";
    }

    /**
     * Muestra el formulario para crear una nueva categoría.
     *
     * @param model Objeto para pasar una instancia vacía de {@link Categoria} a la vista.
     * @return El nombre de la plantilla del formulario.
     */
    @GetMapping("/new")
    public String formularioNuevo(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "admin/categorias/formulario";
    }

    /**
     * Muestra el formulario de edición cargando los datos de una categoría existente.
     *
     * @param id Identificador de la categoría a editar.
     * @param model Objeto para pasar la categoría encontrada a la vista.
     * @return La plantilla del formulario o redirección al listado si no existe el ID.
     */
    @GetMapping("/{id}/edit")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.buscarPorId(id);
        if (categoria.isPresent()) {
            model.addAttribute("categoria", categoria.get());
            return "admin/categorias/formulario";
        }
        return "redirect:/admin/categorias";
    }

    /**
     * Procesa el envío del formulario para guardar o actualizar una categoría.
     *
     * @param categoria Objeto vinculado a los campos del formulario.
     * @param model Objeto para gestionar mensajes de error en la vista.
     * @return Redirección al listado si tiene éxito o vuelve al formulario si hay error.
     */
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

    /**
     * Muestra una página de confirmación previa al borrado de una categoría.
     *
     * @param id Identificador de la categoría a eliminar.
     * @param model Objeto para pasar los datos de la categoría y la URL de acción.
     * @return Plantilla de confirmación de borrado.
     */
    @GetMapping("/{id}/delete")
    public String confirmarBorrado(@PathVariable Long id, Model model) {
        categoriaService.buscarPorId(id).ifPresent(c -> model.addAttribute("elemento", c));
        model.addAttribute("urlBorrar", "/admin/categorias/" + id + "/delete");
        return "admin/confirmar-borrado";
    }

    /**
     * Ejecuta la eliminación definitiva de la categoría.
     * <p>
     * Gestiona excepciones en caso de que la categoría no pueda borrarse por
     * restricciones de integridad referencial (productos vinculados).
     * </p>
     *
     * @param id Identificador de la categoría.
     * @param model Objeto para devolver mensajes de error a la pantalla de confirmación.
     * @return Redirección al listado o vuelta a confirmación con error.
     */
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