package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Rol;
import java.util.Optional;

/**
 * Interfaz de servicio para la gestión de roles de usuario.
 * <p>
 * Define las operaciones de lógica de negocio permitidas sobre la entidad {@link Rol}.
 * Actúa como capa intermedia para desacoplar el acceso a datos (Repository) 
 * del resto de la aplicación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface RolService {

    /**
     * Busca un rol en el sistema a partir de su identificador único.
     * <p>
     * Es esencial para recuperar las autoridades que se asignarán a los usuarios 
     * durante el registro o la edición de perfiles.
     * </p>
     *
     * @param id El identificador del rol (ej: "ADMIN", "USER").
     * @return Un {@link Optional} que contiene el rol si existe, evitando el retorno de nulos.
     */
    Optional<Rol> findById(String id);
}