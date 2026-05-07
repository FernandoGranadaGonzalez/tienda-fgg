package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad {@link Rol}.
 * <p>
 * Gestiona el acceso a datos para los perfiles de usuario. Al utilizar una 
 * cadena de texto (String) como identificador único, permite realizar búsquedas 
 * directas por el código del rol (ej: "ADMIN", "USER") de manera eficiente.
 * </p>
 * 
 * @author Fernando Granada
 * @version 1.0
 */
public interface RolRepository extends JpaRepository<Rol, String> {
}