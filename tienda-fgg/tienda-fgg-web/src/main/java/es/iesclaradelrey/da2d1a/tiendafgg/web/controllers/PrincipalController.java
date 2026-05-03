package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal de la aplicación.
 * <p>
 * Gestiona las peticiones de navegación básicas y el acceso a la página
 * de aterrizaje (landing page) del sitio web. Es el encargado de recibir
 * a los usuarios cuando acceden a la URL raíz.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
public class PrincipalController {

    /**
     * Gestiona la petición a la raíz de la aplicación.
     * <p>
     * Mapea la URL base ({@code /}) para renderizar la página principal
     * definida en la plantilla {@code src/main/resources/templates/index.html}.
     * </p>
     *
     * @return El nombre de la vista principal ("index").
     */
    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}