package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio encargado de la persistencia y gestión de datos de la entidad {@link Marca}.
 * <p>
 * Al extender de {@link JpaRepository}, proporciona de forma out-of-the-box
 * las operaciones estándar para el acceso a la base de datos (MySQL, H2, etc.),
 * incluyendo la persistencia, eliminación y búsqueda de fabricantes o marcas.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}