package es.iesclaradelrey.da2d1a.tiendafgg.security;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio encargado de la recuperación de usuarios para el proceso de autenticación.
 * <p>
 * Implementa la interfaz {@link UserDetailsService} de Spring Security para conectar 
 * el mecanismo de login con la persistencia en base de datos.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class UsuarioDetallesServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    /**
     * Inyecta el repositorio de usuarios para realizar las búsquedas.
     */
    public UsuarioDetallesServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Localiza un usuario en la base de datos basándose en su nombre de usuario.
     * <p>
     * Se marca como {@code @Transactional(readOnly = true)} para asegurar que la 
     * sesión de Hibernate permanezca abierta durante la carga de la colección de roles,
     * evitando errores de carga diferida (LazyInitializationException).
     * </p>
     *
     * @param username El nombre de usuario introducido en el formulario de login.
     * @return Una instancia de {@link UsuarioDetalles} con la información del usuario.
     * @throws UsernameNotFoundException Si el usuario no existe en el sistema.
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        
        return new UsuarioDetalles(usuario);
    }
}