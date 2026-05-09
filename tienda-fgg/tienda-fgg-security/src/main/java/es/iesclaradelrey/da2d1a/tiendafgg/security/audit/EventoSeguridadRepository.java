package es.iesclaradelrey.da2d1a.tiendafgg.security.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para la consulta y análisis de logs de seguridad.
 * <p>
 * Facilita la extracción de datos históricos para auditorías por usuario
 * o por tipo de incidente, manteniendo siempre el orden cronológico inverso.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface EventoSeguridadRepository extends JpaRepository<EventoSeguridad, Long> {

    /**
     * Recupera el historial de seguridad completo de un usuario.
     * Útil para detectar patrones de uso o actividades sospechosas en una cuenta.
     *
     * @param username Nombre del usuario a auditar.
     * @return Lista de eventos ordenada de más reciente a más antiguo.
     */
    List<EventoSeguridad> findByUsernameOrderByFechaHoraDesc(String username);

    /**
     * Filtra eventos por su categoría técnica.
     * Ideal para cuadros de mando (dashboards) donde se quieran ver
     * exclusivamente los fallos de login (LOGIN_FAILURE) recientes.
     *
     * @param tipoEvento Categoría del evento a buscar.
     * @return Lista de eventos del tipo especificado.
     */
    List<EventoSeguridad> findByTipoEventoOrderByFechaHoraDesc(TipoEvento tipoEvento);
}