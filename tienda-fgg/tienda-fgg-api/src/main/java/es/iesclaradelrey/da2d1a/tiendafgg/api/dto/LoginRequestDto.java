package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.Data;

/**
 * DTO para la solicitud de inicio de sesión (Login).
 * <p>
 * Define la estructura de datos que el cliente debe enviar al endpoint
 * de autenticación (/api/v1/auth/login) para obtener sus tokens JWT.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class LoginRequestDto {
    /**
     * Nombre de usuario o identificador único del usuario.
     */
    private String username;

    /**
     * Contraseña en texto plano enviada por el cliente.
     * <p>
     * Nota: Aunque viaje en texto plano en el DTO, la comunicación debe estar
     * protegida por HTTPS para garantizar la confidencialidad.
     * </p>
     */
    private String password;
}