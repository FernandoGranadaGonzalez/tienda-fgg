package es.iesclaradelrey.da2d1a.tiendafgg.security.audit;

/**
 * Fachada de servicios para el registro centralizado de eventos de auditoría.
 * <p>
 * Este servicio desacopla la lógica de captura de eventos (Handlers, Filtros)
 * de la lógica de persistencia (Repositories), permitiendo un registro
 * uniforme en toda la aplicación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface EventoSeguridadService {

    /**
     * Registra un evento de seguridad con información contextual completa.
     *
     * @param username Identidad del usuario (o intento de nombre de usuario).
     * @param tipo     Categoría del evento (LOGIN_SUCCESS, LOGIN_FAILURE, etc.).
     * @param ip       Dirección IP de origen de la petición.
     * @param detalle  Información técnica adicional o causa del evento.
     */
    void registrar(String username, TipoEvento tipo, String ip, String detalle);

    /**
     * Sobrecarga simplificada para registros que no requieren información adicional.
     * <p>
     * Proporciona una implementación por defecto que delega en el método principal
     * pasando un valor nulo en el campo de detalle.
     * </p>
     *
     * @param username Identidad del usuario.
     * @param tipo     Categoría del evento.
     * @param ip       Dirección IP de origen.
     */
    default void registrar(String username, TipoEvento tipo, String ip) {
        registrar(username, tipo, ip, null);
    }
}