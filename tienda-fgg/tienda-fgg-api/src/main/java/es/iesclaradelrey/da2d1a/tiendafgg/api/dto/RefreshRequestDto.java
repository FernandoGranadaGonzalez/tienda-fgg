package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.Data;

/**
 * DTO para la solicitud de renovación de tokens (Refresh Token).
 * <p>
 * Se utiliza cuando el cliente detecta que su Access Token ha expirado
 * y desea obtener uno nuevo enviando el token de refresco persistido.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class RefreshRequestDto {
    /**
     * El token de refresco de larga duración (Refresh Token)
     * proporcionado inicialmente durante el login.
     */
    private String refreshToken;
}