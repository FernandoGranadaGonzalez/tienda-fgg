package es.iesclaradelrey.da2d1a.tiendafgg.security.audit;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Escuchador de eventos de ciclo de vida de autenticación.
 * <p>
 * Captura de forma asíncrona o síncrona los hitos de seguridad publicados por
 * Spring Security, actuando como el nexo entre el motor de seguridad y el
 * sistema de auditoría persistente.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Component
public class SecurityEventListener {

    private final EventoSeguridadService eventoService;

    public SecurityEventListener(EventoSeguridadService eventoService) {
        this.eventoService = eventoService;
    }

    /**
     * Registra accesos exitosos realizados a través de interfaces interactivas.
     * <p>
     * Se filtra específicamente por InteractiveAuthenticationSuccessEvent para
     * evitar ruido de auditoría generado por chequeos internos del framework.
     * </p>
     */
    @EventListener
    public void onLoginSuccess(InteractiveAuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();
        eventoService.registrar(username, TipoEvento.LOGIN_OK, obtenerIp());
    }

    /**
     * Captura cualquier intento fallido de acceso.
     * <p>
     * Almacena tanto el nombre de usuario intentado como el motivo técnico
     * del rechazo (ej. Bad Credentials, Locked account).
     * </p>
     */
    @EventListener
    public void onLoginFailure(AbstractAuthenticationFailureEvent event) {
        String username = event.getAuthentication().getName();
        String detalle  = event.getException().getMessage();
        eventoService.registrar(username, TipoEvento.LOGIN_ERROR, obtenerIp(), detalle);
    }

    /**
     * Extrae la dirección IP del cliente desde el contexto de la petición actual.
     * <p>
     * Implementa una lógica de recuperación segura que contempla proxies (X-Forwarded-For)
     * y maneja excepciones en caso de llamadas fuera de un contexto Web.
     * </p>
     */
    private String obtenerIp() {
        try {
            ServletRequestAttributes attrs =
                    (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = attrs.getRequest();
            String ip = request.getHeader("X-Forwarded-For");
            return (ip != null && !ip.isBlank()) ? ip.split(",")[0].trim() : request.getRemoteAddr();
        } catch (Exception e) {
            return "desconocida";
        }
    }
}