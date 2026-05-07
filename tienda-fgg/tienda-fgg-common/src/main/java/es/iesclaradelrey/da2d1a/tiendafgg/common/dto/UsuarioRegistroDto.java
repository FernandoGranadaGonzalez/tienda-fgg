package es.iesclaradelrey.da2d1a.tiendafgg.common.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Objeto de Transferencia de Datos (DTO) para el proceso de registro de nuevos usuarios.
 * <p>
 * Esta clase se encarga de transportar la información desde el formulario de registro
 * hacia el controlador, aplicando reglas de validación básicas mediante anotaciones 
 * de Jakarta Validation para garantizar la integridad de los datos de entrada.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class UsuarioRegistroDto {

    /**
     * Nombre de identificación del usuario en la plataforma.
     * Debe ser único y cumplir con una longitud de entre 4 y 20 caracteres.
     */
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 4, max = 20, message = "El usuario debe tener entre 4 y 20 caracteres")
    private String username;

    /**
     * Contraseña de acceso. 
     * Se requiere una longitud mínima de 6 caracteres por seguridad.
     */
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    /**
     * Dirección de correo electrónico del usuario.
     * Se valida que cumpla con el formato estándar de email.
     */
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un email válido")
    private String email;

    /**
     * Nombre real del usuario (opcional).
     */
    private String nombre;

    /**
     * Apellidos del usuario (opcional).
     */
    private String apellidos;

    /**
     * Flag que indica si el usuario ha aceptado los términos y condiciones.
     * Es obligatorio que sea {@code true} para permitir el registro.
     */
    @AssertTrue(message = "Debes aceptar las condiciones para registrarte")
    private boolean aceptoCondiciones;
}