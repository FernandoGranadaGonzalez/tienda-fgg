package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO de respuesta tras una autenticación exitosa.
 * <p>
 * Este objeto contiene el par de tokens necesarios para que el cliente
 * gestione la seguridad de forma autónoma (Stateless).
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class TokenResponseDto {
    /**
     * Token de corta duración (ej: 15-30 min) enviado en cada petición
     * en la cabecera 'Authorization: Bearer'.
     */
    private String accessToken;

    /**
     * Token de larga duración (ej: 7 días) utilizado exclusivamente
     * para obtener nuevos Access Tokens cuando estos expiren.
     */
    private String refreshToken;
}