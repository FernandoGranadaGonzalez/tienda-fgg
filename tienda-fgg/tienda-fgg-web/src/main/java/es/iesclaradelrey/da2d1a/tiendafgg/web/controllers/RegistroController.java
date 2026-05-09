package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.dto.UsuarioRegistroDto;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para la creación de nuevas cuentas de usuario.
 * <p>
 * Gestiona el ciclo de vida del alta de usuarios, desde la presentación del
 * formulario hasta la validación de datos y persistencia final a través
 * del servicio de usuarios.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
@RequestMapping("/register")
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Prepara el modelo con un DTO vacío para el formulario.
     * @return Vista 'registro'.
     */
    @GetMapping
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new UsuarioRegistroDto());
        return "registro";
    }

    /**
     * Procesa la solicitud de alta de usuario.
     * <p>
     * Valida los requisitos de entrada y delega la lógica de negocio al servicio.
     * Si el registro es exitoso, redirige al login con un parámetro de éxito.
     * </p>
     *
     * @param registroDto Datos del nuevo usuario validados.
     * @param bindingResult Resultado de la validación.
     * @return Redirección a login o vuelta al formulario con errores.
     */
    @PostMapping
    public String registrarUsuario(@Valid @ModelAttribute("usuario") UsuarioRegistroDto registroDto,
                                   BindingResult bindingResult,
                                   Model model) {

        if (bindingResult.hasErrors()) {
            return "registro";
        }

        try {
            usuarioService.registrar(registroDto);
            return "redirect:/login?registrado";
        } catch (Exception e) {
            model.addAttribute("errorRegistro", "Error al crear el usuario: " + e.getMessage());
            return "registro";
        }
    }
}