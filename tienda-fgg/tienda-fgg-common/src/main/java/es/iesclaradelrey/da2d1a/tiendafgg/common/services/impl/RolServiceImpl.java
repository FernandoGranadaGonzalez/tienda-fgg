package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Rol;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.RolRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.RolService;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Implementación del servicio de gestión de roles.
 * <p>
 * Se encarga de la lógica de negocio relacionada con los perfiles de usuario. 
 * Al implementar {@link RolService}, permite desacoplar la capa de persistencia 
 * de la capa de presentación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    /**
     * Inyección de dependencias mediante constructor.
     *
     * @param rolRepository Repositorio de acceso a datos de roles.
     */
    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    /**
     * Recupera un rol específico por su identificador único.
     * <p>
     * Este método es fundamental durante el registro de nuevos usuarios para 
     * asignarles un perfil válido (ej: "USER") consultado previamente en la base de datos.
     * </p>
     *
     * @param id Identificador del rol (String).
     * @return Un {@link Optional} con el rol si existe.
     */
    @Override
    public Optional<Rol> findById(String id) {
        return rolRepository.findById(id);
    }
}