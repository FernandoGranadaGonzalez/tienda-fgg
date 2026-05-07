package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.UsuarioService;
import es.iesclaradelrey.da2d1a.tiendafgg.security.UsuarioDetalles;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Muestra el perfil del usuario autenticado.
     * Redirige a la URL con ID para cumplir con el requisito 3.6.
     */
    @GetMapping("/profile")
    public String verPerfilPropio(@AuthenticationPrincipal UsuarioDetalles userDetails) {
        return "redirect:/users/profile/" + userDetails.getId();
    }

    /**
     * Tarea 3.6: URL alternativa para consulta de perfil por ID.
     * Restricción: Solo ADMIN o el propio usuario titular del ID.
     */
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping("/profile/{id}")
    public String verPerfilPorId(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario con ID " + id + " no encontrado"));

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de " + usuario.getUsername());
        return "users/profile";
    }
}