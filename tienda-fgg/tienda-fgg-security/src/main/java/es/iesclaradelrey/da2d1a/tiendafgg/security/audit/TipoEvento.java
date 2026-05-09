package es.iesclaradelrey.da2d1a.tiendafgg.security.audit;

/**
 * Catálogo de tipos de eventos de seguridad auditables en la TiendaFGG.
 * <p>
 * Este enumerado tipifica las acciones críticas que deben ser monitorizadas,
 * facilitando el filtrado y la generación de reportes desde el repositorio
 * de auditoría.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public enum TipoEvento {
    /**
     * Indica una autenticación exitosa.
     * Registrado generalmente por el {@code SecurityEventListener}.
     */
    LOGIN_OK,

    /**
     * Indica un intento fallido de acceso (credenciales erróneas, cuenta bloqueada, etc.).
     * Crucial para la detección de ataques de fuerza bruta.
     */
    LOGIN_ERROR,

    /**
     * Indica el cierre de sesión voluntario del usuario.
     * Registrado por el {@code AuditLogoutHandler}.
     */
    LOGOUT
}