package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la gestión de roles de usuario.
 * <p>
 * Al utilizar String como tipo de identificador, permite operaciones
 * directas sobre los nombres de los roles (USER, ADMIN) sin necesidad
 * de manejar IDs numéricos autoincrementales.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface RolRepository extends JpaRepository<Rol, String> {
}