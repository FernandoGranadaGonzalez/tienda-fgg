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
 * Controlador para la gestión del proceso de registro de nuevos usuarios.
 * <p>
 * Maneja la visualización del formulario y el procesamiento de los datos 
 * enviados, integrando validación de campos y captura de excepciones de negocio.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Controller
@RequestMapping("/register")
public class RegistroController {

    private final UsuarioService usuarioService;

    /**
     * Inyección del servicio de usuarios.
     */
    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Prepara y muestra el formulario de registro.
     *
     * @param model Modelo para pasar un DTO vacío a la vista.
     * @return El nombre de la plantilla "registro".
     */
    @GetMapping
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new UsuarioRegistroDto());
        return "registro";
    }

    /**
     * Procesa el envío del formulario de registro.
     *
     * @param registroDto Objeto con los datos del formulario.
     * @param bindingResult Resultado de la validación de Bean Validation.
     * @param model Modelo para gestionar mensajes de error.
     * @return Redirección al login si tiene éxito, o vuelta al formulario si hay errores.
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