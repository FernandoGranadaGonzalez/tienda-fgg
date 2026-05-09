package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repositorio de persistencia para la gestión de usuarios.
 * <p>
 * Proporciona métodos de búsqueda unívoca esenciales para los procesos de:
 * <ul>
 *     <li>Autenticación (carga por username).</li>
 *     <li>Recuperación de cuenta (carga por email).</li>
 *     <li>Validación de registro (comprobación de duplicados).</li>
 * </ul>
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Recupera un usuario por su nombre de cuenta.
     * Fundamental para la integración con el UserDetailsService de Spring Security.
     */
    Optional<Usuario> findByUsername(String username);

    /**
     * Localiza un usuario por su dirección de correo electrónico.
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Verifica si un nombre de usuario ya está en uso.
     * Se utiliza en la capa de servicio antes de procesar un nuevo registro.
     */
    boolean existsByUsername(String username);

    /**
     * Verifica si un email ya está registrado.
     * Ayuda a prevenir la creación de cuentas duplicadas con el mismo correo.
     */
    boolean existsByEmail(String email);
}