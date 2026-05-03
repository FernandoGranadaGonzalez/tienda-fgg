package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador web responsable de gestionar las páginas estáticas o informativas del sitio.
 * <p>
 * Se encarga de mapear las peticiones HTTP GET a las vistas correspondientes,
 * facilitando la navegación por secciones informativas que no requieren
 * procesamiento de datos complejos o acceso a la capa de servicios.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
public class AcercaController {

    /**
     * Gestiona la petición a la página de información corporativa "Sobre nosotros".
     * <p>
     * Mapea la URL {@code /sobre-nosotros} para renderizar la plantilla
     * ubicada en {@code src/main/resources/templates/about-us.html}.
     * </p>
     *
     * @return El nombre de la vista (template) a renderizar.
     */
    @GetMapping("/sobre-nosotros")
    public String sobreNosotros() {
        return "about-us";
    }

    /**
     * Gestiona la petición a la página de términos y condiciones legales.
     * <p>
     * Mapea la URL {@code /condiciones} para renderizar la plantilla
     * ubicada en {@code src/main/resources/templates/legal/terms.html}.
     * </p>
     * <p>
     * <b>Nota:</b> Si esta ruta también está definida en {@code WebConfiguracion},
     * Spring priorizará una de las dos. Es recomendable centralizar los mapeos
     * simples en un solo lugar para evitar conflictos de ambigüedad.
     * </p>
     *
     * @return El nombre de la vista (template) a renderizar.
     */
    @GetMapping("/condiciones")
    public String condiciones() {
        return "legal/terms";
    }
}