package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.dto.UsuarioRegistroDto;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Rol;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.RolRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.UsuarioRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * Servicio de gestión de usuarios e identidad.
 * <p>
 * Centraliza las operaciones de búsqueda y registro, aplicando el cifrado
 * de credenciales mediante BCrypt y la asignación automática de roles.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              RolRepository rolRepository,
                              PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Procesa el registro de un nuevo cliente.
     * <p>
     * Realiza validaciones de unicidad antes de persistir y transforma
     * la contraseña plana en un hash seguro. Por defecto, otorga el rol 'USER'.
     * </p>
     *
     * @param dto Datos del formulario de registro.
     * @return El usuario persistido con su ID generado.
     * @throws IllegalArgumentException si el username o email están duplicados.
     */
    @Override
    public Usuario registrar(UsuarioRegistroDto dto) {
        if (usuarioRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
        }
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado.");
        }

        Rol rolUser = rolRepository.findById("USER")
                .orElseThrow(() -> new IllegalStateException("Rol USER no encontrado en BD."));

        Usuario usuario = Usuario.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword())) // Hash irreversible
                .email(dto.getEmail())
                .nombre(dto.getNombre())
                .apellidos(dto.getApellidos())
                .enabled(true)
                .roles(Set.of(rolUser))
                .build();

        return usuarioRepository.save(usuario);
    }
}