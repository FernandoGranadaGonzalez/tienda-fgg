package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de administración encargado de centralizar el acceso al panel de gestión.
 * <p>
 * Este controlador define el punto de entrada para los administradores y gestiona
 * las redirecciones necesarias para mantener URLs limpias y corregir accesos
 * a rutas antiguas o con barras finales (trailing slashes).
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * Muestra la página principal (dashboard) del panel de administración.
     *
     * @return El nombre de la vista principal de administración {@code admin/index}.
     */
    @GetMapping
    public String index() {
        return "admin/index";
    }

    /**
     * Redirige las peticiones que llegan con barra final {@code /admin/}
     * hacia la ruta base de administración.
     *
     * @return Una instrucción de redirección a {@code /admin}.
     */
    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/admin";
    }

    /**
     * Redirige las peticiones de la ruta antigua o alternativa de videojuegos
     * hacia la sección de gestión de productos.
     *
     * @return Una instrucción de redirección a {@code /admin/productos}.
     */
    @GetMapping("/videojuegos/")
    public String redirectVideojuegos() {
        return "redirect:/admin/productos";
    }

    /**
     * Gestiona la redirección para la sección de categorías dentro del panel.
     *
     * @return Una instrucción de redirección a la ruta normalizada de categorías.
     */
    @GetMapping("/categorias/")
    public String redirectCategorias() {
        return "redirect:/admin/categorias";
    }

    /**
     * Gestiona la redirección para la sección de marcas dentro del panel.
     *
     * @return Una instrucción de redirección a la ruta normalizada de marcas.
     */
    @GetMapping("/marcas/")
    public String redirectMarcas() {
        return "redirect:/admin/marcas";
    }
}