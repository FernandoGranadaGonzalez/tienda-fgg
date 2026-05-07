package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repositorio para la entidad {@link Usuario}.
 * <p>
 * Define las operaciones de acceso a datos necesarias para la autenticación 
 * y gestión de cuentas de usuario. Incluye métodos de búsqueda por credenciales 
 * y comprobaciones de existencia para procesos de registro.
 * </p>
 * 
 * @author Fernando Granada
 * @version 1.0
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     * Utilizado principalmente por el servicio de autenticación de Spring Security.
     * 
     * @param username El nombre de usuario a buscar.
     * @return Un {@link Optional} que contiene el usuario si se encuentra, o vacío si no.
     */
    Optional<Usuario> findByUsername(String username);

    /**
     * Busca un usuario por su dirección de correo electrónico.
     * Útil para procesos de recuperación de contraseña o login alternativo.
     * 
     * @param email El correo electrónico a buscar.
     * @return Un {@link Optional} que contiene el usuario si se encuentra.
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Comprueba si ya existe un usuario registrado con el nombre de usuario indicado.
     * 
     * @param username Nombre de usuario a verificar.
     * @return {@code true} si ya existe, {@code false} en caso contrario.
     */
    boolean existsByUsername(String username);

    /**
     * Comprueba si ya existe un usuario registrado con el correo indicado.
     * 
     * @param email Correo electrónico a verificar.
     * @return {@code true} si el email ya está en uso.
     */
    boolean existsByEmail(String email);
}