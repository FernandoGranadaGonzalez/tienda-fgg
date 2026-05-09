package es.iesclaradelrey.da2d1a.tiendafgg.security.audit;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

/**
 * Componente de auditoría interceptor del proceso de cierre de sesión.
 * <p>
 * Este manejador captura el evento de salida justo antes de que el contexto de
 * seguridad sea destruido, permitiendo registrar de forma persistente qué
 * usuario finaliza su sesión y desde qué ubicación (IP).
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Component
public class AuditLogoutHandler implements LogoutHandler {

    private final EventoSeguridadService eventoService;

    public AuditLogoutHandler(EventoSeguridadService eventoService) {
        this.eventoService = eventoService;
    }

    /**
     * Intercepta el flujo de logout para registrar la auditoría.
     *
     * @param request        La petición HTTP entrante.
     * @param response       La respuesta HTTP saliente.
     * @param authentication El objeto que contiene la identidad del usuario actual.
     */
    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {

        String username = (authentication != null) ? authentication.getName() : "anónimo";

        String ip = obtenerIp(request);

        eventoService.registrar(username, TipoEvento.LOGOUT, ip);
    }

    /**
     * Método de utilidad para extraer la IP real del cliente.
     * <p>
     * Considera el encabezado 'X-Forwarded-For' para soportar escenarios donde
     * la aplicación esté detrás de un Proxy Inverso o un Balanceador de Carga.
     * </p>
     */
    private String obtenerIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        return (ip != null && !ip.isBlank()) ? ip.split(",")[0].trim() : request.getRemoteAddr();
    }
}