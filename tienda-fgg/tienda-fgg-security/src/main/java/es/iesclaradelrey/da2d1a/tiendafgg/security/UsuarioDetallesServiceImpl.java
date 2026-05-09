package es.iesclaradelrey.da2d1a.tiendafgg.security;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de la recuperación de identidades para el proceso de autenticación.
 * <p>
 * Implementa la interfaz central de Spring Security para cargar datos de usuario
 * personalizados, permitiendo que el framework valide las credenciales contra
 * la base de datos de la aplicación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class UsuarioDetallesServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioDetallesServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Localiza al usuario en la base de datos y lo transforma en un objeto UserDetails.
     * <p>
     * Este método es invocado internamente por el {@code AuthenticationManager}
     * durante el flujo de login o validación de tokens.
     * </p>
     *
     * @param username El nombre de usuario introducido en el formulario/petición.
     * @return Una instancia de {@link UsuarioDetalles} con los datos y roles del usuario.
     * @throws UsernameNotFoundException Si el usuario no existe en el sistema.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando en BD al usuario: " + username);

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new UsuarioDetalles(usuario);
    }
}