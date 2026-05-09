package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador encargado de la navegación relacionada con la autenticación.
 * <p>
 * Gestiona el acceso a la página de inicio de sesión y la visualización de
 * errores de autorización cuando un usuario carece de los permisos necesarios.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
public class LoginController {

    /**
     * Muestra el formulario de acceso personalizado.
     * @return Nombre de la plantilla Thymeleaf 'login'.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Muestra la página informativa cuando se intenta acceder a un recurso prohibido.
     * @return Ruta a la vista de error 403.
     */
    @GetMapping("/acceso-denegado")
    public String accesoDenegado() {
        return "error/403";
    }
}