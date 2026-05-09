package es.iesclaradelrey.da2d1a.tiendafgg.api.jwt;

/**
 * Enumeración para distinguir el propósito de los tokens JWT.
 * <p>
 * Se utiliza como un 'claim' personalizado dentro del payload del token
 * para evitar el uso cruzado de tokens de acceso y de refresco.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public enum TipoToken {
    /**
     * Token de corta duración para autenticar peticiones a recursos protegidos.
     */
    ACCESS,

    /**
     * Token de larga duración utilizado únicamente para obtener nuevos tokens de acceso.
     */
    REFRESH
}