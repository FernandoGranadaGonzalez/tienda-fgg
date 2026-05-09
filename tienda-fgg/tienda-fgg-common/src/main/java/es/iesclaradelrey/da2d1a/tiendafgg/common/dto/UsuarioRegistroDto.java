package es.iesclaradelrey.da2d1a.tiendafgg.common.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Objeto de Transferencia de Datos (DTO) para el registro de nuevos usuarios.
 * <p>
 * Define las reglas de validación de entrada para garantizar la integridad
 * de la base de datos de usuarios y el cumplimiento de las políticas de seguridad.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class UsuarioRegistroDto {

    /** Nombre de identificación único en el sistema. */
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 4, max = 20, message = "El usuario debe tener entre 4 y 20 caracteres")
    private String username;

    /**
     * Contraseña en texto plano (será encriptada por BCrypt en el servicio).
     * Se exige un mínimo de seguridad de 6 caracteres.
     */
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    /** Correo electrónico de contacto y recuperación. */
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un email válido")
    private String email;

    private String nombre;
    private String apellidos;

    /**
     * Validación lógica para el cumplimiento legal (RGPD).
     * El registro fallará si este campo no es true.
     */
    @AssertTrue(message = "Debes aceptar las condiciones para registrarte")
    private boolean aceptoCondiciones;
}