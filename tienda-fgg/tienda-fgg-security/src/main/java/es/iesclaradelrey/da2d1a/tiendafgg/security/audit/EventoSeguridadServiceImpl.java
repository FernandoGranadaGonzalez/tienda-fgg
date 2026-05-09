package es.iesclaradelrey.da2d1a.tiendafgg.security.audit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

/**
 * Implementación del servicio de auditoría de seguridad.
 * <p>
 * Se encarga de transformar los parámetros de los eventos en entidades
 * persistentes, asegurando que cada acción relevante en el sistema
 * quede documentada con su marca temporal y contexto de origen.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class EventoSeguridadServiceImpl implements EventoSeguridadService {

    private final EventoSeguridadRepository repository;

    public EventoSeguridadServiceImpl(EventoSeguridadRepository repository) {
        this.repository = repository;
    }

    /**
     * Crea y persiste un nuevo evento de seguridad.
     * <p>
     * Utiliza el patrón Builder para una construcción clara de la entidad
     * y captura la fecha/hora actual del sistema en el momento de la llamada.
     * </p>
     */
    @Override
    @Transactional
    public void registrar(String username, TipoEvento tipo, String ip, String detalle) {
        EventoSeguridad evento = EventoSeguridad.builder()
                .fechaHora(LocalDateTime.now())
                .username(username)
                .tipoEvento(tipo)
                .ipOrigen(ip)
                .detalle(detalle)
                .build();

        repository.save(evento);
    }
}