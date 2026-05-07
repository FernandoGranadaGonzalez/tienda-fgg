package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

/**
 * Enumeración que define los tipos de eventos de seguridad monitorizados en el sistema.
 * <p>
 * Se utiliza para categorizar las acciones de autenticación y permitir un análisis
 * claro de la actividad en la tabla de auditoría {@code eventos_seguridad}.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public enum TipoEvento {

    /**
     * Registra un inicio de sesión completado correctamente.
     */
    LOGIN_EXITO,

    /**
     * Registra un intento de acceso con credenciales erróneas o bloqueadas.
     * Útil para detectar ataques de fuerza bruta.
     */
    LOGIN_FALLIDO,

    /**
     * Registra la salida voluntaria del usuario de la aplicación.
     */
    LOGOUT
}