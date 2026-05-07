package es.iesclaradelrey.da2d1a.tiendafgg.security;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.EventoSeguridad;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.TipoEvento;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.EventoSeguridadRepository;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * Componente encargado de interceptar y registrar eventos de autenticación.
 * <p>
 * Utiliza el mecanismo de publicación/suscripción de eventos de Spring Context
 * para capturar tanto los inicios de sesión exitosos como los fallidos,
 * persistiendo esta información en la tabla de auditoría de seguridad.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Component
public class LoginEventListener {

    private final EventoSeguridadRepository eventoRepository;

    /**
     * Inyección del repositorio para persistir los eventos.
     */
    public LoginEventListener(EventoSeguridadRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    /**
     * Se ejecuta automáticamente tras una autenticación exitosa.
     * <p>
     * Registra un evento de tipo {@link TipoEvento#LOGIN_EXITO} asociándolo
     * al nombre del usuario que acaba de acceder.
     * </p>
     *
     * @param event Objeto que contiene los detalles de la autenticación exitosa.
     */
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();
        EventoSeguridad evento = EventoSeguridad.builder()
                .username(username)
                .tipoEvento(TipoEvento.LOGIN_EXITO)
                .detalles("Login correcto")
                .build();
        eventoRepository.save(evento);
    }

    /**
     * Se ejecuta automáticamente cuando falla una autenticación por credenciales erróneas.
     * <p>
     * Registra un evento de tipo {@link TipoEvento#LOGIN_FALLIDO}. Es vital para
     * monitorizar posibles ataques de fuerza bruta.
     * </p>
     *
     * @param event Objeto que contiene los detalles del intento fallido.
     */
    @EventListener
    public void onFailure(AuthenticationFailureBadCredentialsEvent event) {
        String username = (String) event.getAuthentication().getPrincipal();
        EventoSeguridad evento = EventoSeguridad.builder()
                .username(username)
                .tipoEvento(TipoEvento.LOGIN_FALLIDO)
                .detalles("Contraseña incorrecta o usuario inexistente")
                .build();
        eventoRepository.save(evento);
    }
}