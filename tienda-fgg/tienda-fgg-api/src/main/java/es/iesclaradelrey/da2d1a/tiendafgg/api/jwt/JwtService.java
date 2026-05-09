package es.iesclaradelrey.da2d1a.tiendafgg.api.jwt;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Contrato para la gestión de tokens JSON Web Token (JWT).
 * <p>
 * Define las operaciones necesarias para el ciclo de vida de la autenticación
 * stateless, incluyendo la generación de tokens de acceso y refresco,
 * así como la validación de integridad y expiración.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface JwtService {

    /**
     * Genera un token de acceso (Access Token) de corta duración.
     * @param user Detalles del usuario autenticado.
     * @return String con el JWT firmado.
     */
    String generateAccessToken(UserDetails user);

    /**
     * Genera un token de larga duración para renovar sesiones (Refresh Token).
     * @param user Detalles del usuario autenticado.
     * @return String con el JWT de refresco.
     */
    String generateRefreshToken(UserDetails user);

    /**
     * Recupera el 'subject' (nombre de usuario) contenido en el cuerpo del token.
     * @param token JWT a procesar.
     * @return Nombre de usuario extraído de los claims.
     */
    String extractUsername(String token);

    /**
     * Verifica si el tiempo de vida del token ha superado la fecha actual.
     * @param token JWT a comprobar.
     * @return true si ha expirado, false en caso contrario.
     */
    Boolean isTokenExpired(String token);

    /**
     * Realiza una validación completa del token.
     * Verifica que la firma sea íntegra, que no haya expirado y que el
     * usuario del token coincida con el usuario del sistema.
     *
     * @param token JWT a validar.
     * @param user Usuario contra el que se contrasta la identidad.
     * @return true si el token es plenamente confiable.
     */
    Boolean isTokenValid(String token, UserDetails user);
}