package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Objeto de transferencia de datos para la respuesta de renovación de token.
 * <p>
 * Se utiliza específicamente en el endpoint de "refresh" para devolver
 * un nuevo Access Token al cliente sin necesidad de incluir un nuevo
 * Refresh Token en la misma respuesta.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class AccessTokenResponseDto {
    /**
     * El nuevo token de acceso JWT generado para el usuario.
     */
    private String accessToken;
}