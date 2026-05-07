package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador encargado de gestionar las vistas de autenticación y errores de acceso.
 * <p>
 * Proporciona los puntos de entrada para el formulario de inicio de sesión personalizado
 * y la gestión visual de las restricciones de seguridad (acceso denegado).
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
public class LoginController {

    /**
     * Muestra el formulario de inicio de sesión.
     * <p>
     * Este método intercepta tanto la petición inicial al login como las redirecciones
     * automáticas que realiza Spring Security cuando la autenticación falla.
     * </p>
     *
     * @param error Parámetro opcional enviado por Spring Security en caso de fallo.
     * @param model Modelo para pasar atributos a la vista Thymeleaf.
     * @return El nombre de la plantilla HTML "login".
     */
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario y/o contraseña incorrectos.");
        }
        return "login";
    }

    /**
     * Gestiona las peticiones de usuarios que intentan acceder a rutas sin los permisos necesarios.
     * <p>
     * Redirige a una vista de error específica (403 Forbidden) para informar al usuario
     * de que su rol no tiene privilegios para dicha sección.
     * </p>
     *
     * @param model Modelo para la vista.
     * @return El nombre de la plantilla "errors/403".
     */
    @GetMapping("/acceso-denegado")
    public String accesoDenegado(Model model) {
        model.addAttribute("titulo", "Acceso Restringido");
        return "errors/403";
    }
}