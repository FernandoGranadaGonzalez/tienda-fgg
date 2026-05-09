package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.UsuarioService;
import es.iesclaradelrey.da2d1a.tiendafgg.security.UsuarioDetalles;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Controlador para la visualización y gestión de perfiles de usuario.
 * <p>
 * Centraliza la lógica de visualización de datos personales, aplicando
 * reglas de negocio para restringir el acceso a perfiles ajenos.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private final UsuarioService usuarioService;

    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Resuelve el perfil del usuario en sesión.
     * <p>
     * Aprovecha el objeto principal de autenticación para obtener los datos
     * sin realizar consultas adicionales a la base de datos.
     * </p>
     */
    @GetMapping("/profile")
    public String miPerfil(Model model,
                           @AuthenticationPrincipal UsuarioDetalles userDetails) {
        model.addAttribute("usuario", userDetails.getUsuario());
        return "users/profile";
    }

    /**
     * Resuelve un perfil específico mediante su identificador único.
     * <p>
     * Implementa una guarda de seguridad que solo permite la visualización
     * si el solicitante tiene privilegios de administrador o si es el
     * propietario del perfil solicitado.
     * </p>
     */
    @GetMapping("/profile/{userId}")
    public String perfilPorId(@PathVariable Long userId,
                              Model model,
                              @AuthenticationPrincipal UsuarioDetalles userDetails) {

        boolean esAdmin = userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        boolean esPropioUsuario = userDetails.getUsuario().getId().equals(userId);

        if (!esAdmin && !esPropioUsuario) {
            return "redirect:/acceso-denegado";
        }

        Optional<Usuario> usuario = usuarioService.findById(userId);
        if (usuario.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("usuario", usuario.get());
        return "users/profile";
    }
}