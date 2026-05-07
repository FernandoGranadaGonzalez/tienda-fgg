package es.iesclaradelrey.da2d1a.tiendafgg.security;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.EventoSeguridad;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.TipoEvento;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.EventoSeguridadRepository;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * Componente encargado de monitorizar y registrar el fin de las sesiones de usuario.
 * <p>
 * Este listener reacciona ante los eventos de logout gestionados por Spring Security,
 * permitiendo auditar cuándo un usuario decide finalizar su sesión activa de manera
 * explícita.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Component
public class LogoutEventListener {

    private final EventoSeguridadRepository eventoRepository;

    /**
     * Inyección del repositorio de eventos de seguridad.
     */
    public LogoutEventListener(EventoSeguridadRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    /**
     * Captura el evento de cierre de sesión exitoso.
     * <p>
     * Extrae el nombre de usuario de la autenticación que está a punto de 
     * destruirse y registra un evento de tipo {@link TipoEvento#LOGOUT}
     * en el historial de seguridad.
     * </p>
     *
     * @param event Objeto que contiene la información de la sesión que se cierra.
     */
    @EventListener
    public void onLogoutSuccess(LogoutSuccessEvent event) {
        String username = event.getAuthentication().getName();
        
        EventoSeguridad evento = EventoSeguridad.builder()
                .username(username)
                .tipoEvento(TipoEvento.LOGOUT)
                .detalles("Cierre de sesión exitoso")
                .build();

        eventoRepository.save(evento);
    }
}