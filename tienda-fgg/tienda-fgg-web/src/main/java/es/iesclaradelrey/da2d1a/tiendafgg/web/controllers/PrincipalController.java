package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal de la aplicación.
 * <p>
 * Gestiona las peticiones de navegación básicas y el acceso a la página
 * de aterrizaje (landing page) del sitio web.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Controller
public class PrincipalController {

    /**
     * Gestiona la petición a la raíz de la aplicación.
     * <p>
     * Mapea la URL base ({@code /}) para renderizar la página principal
     * definida en la plantilla {@code index.html}.
     * </p>
     *
     * @return El nombre de la vista principal.
     */
    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}