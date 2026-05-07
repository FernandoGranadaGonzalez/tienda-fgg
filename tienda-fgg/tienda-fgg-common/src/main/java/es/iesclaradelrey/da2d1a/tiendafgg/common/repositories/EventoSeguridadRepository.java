package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.EventoSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad {@link EventoSeguridad}.
 * <p>
 * Proporciona los métodos necesarios para la persistencia de los eventos de auditoría
 * y seguridad en la base de datos. Al extender de {@link JpaRepository}, incluye
 * funcionalidades de paginación, ordenación y operaciones CRUD básicas.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Repository
public interface EventoSeguridadRepository extends JpaRepository<EventoSeguridad, Long> {
}