package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador web responsable de gestionar las páginas estáticas o informativas.
 * <p>
 * Se encarga de mapear las peticiones HTTP GET a las vistas correspondientes,
 * facilitando la navegación por páginas que no requieren interacción con la capa
 * de servicios o acceso a base de datos.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Controller
public class AcercaController {

    /**
     * Gestiona la petición a la página de "Sobre nosotros".
     * <p>
     * Mapea la URL {@code /sobre-nosotros} para renderizar la plantilla
     * HTML definida en {@code about-us.html}.
     * </p>
     *
     * @return El nombre de la vista (template) a renderizar.
     */
    @GetMapping("/sobre-nosotros")
    public String sobreNosotros() {
        return "about-us";
    }

    /**
     * Gestiona la petición a la página de términos y condiciones.
     * <p>
     * Mapea la URL {@code /condiciones} para renderizar la plantilla
     * {@code legal/terms.html}.
     * </p>
     *
     * @return El nombre de la vista (template) a renderizar.
     */
    @GetMapping("/condiciones")
    public String condiciones() {
        return "legal/terms";
    }
}