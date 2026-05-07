package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Rol;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.UsuarioRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.dto.UsuarioRegistroDto;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.RolService;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Implementación del servicio de gestión de usuarios.
 * <p>
 * Centraliza la lógica de negocio para el ciclo de vida de los usuarios, 
 * encargándose de los procesos de registro, validación de credenciales,
 * cifrado de seguridad y asignación de perfiles.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolService rolService;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param usuarioRepository Acceso a datos de usuarios.
     * @param passwordEncoder Componente para el hash de contraseñas (ej: BCrypt).
     * @param rolService Servicio para la gestión y búsqueda de roles.
     */
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              PasswordEncoder passwordEncoder,
                              RolService rolService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolService = rolService;
    }

    /**
     * Procesa el registro de un nuevo usuario en la plataforma.
     * <p>
     * Realiza las siguientes operaciones críticas:
     * 1. Verifica la disponibilidad del nombre de usuario y email.
     * 2. Mapea la información del DTO a la entidad de persistencia.
     * 3. Aplica hashing a la contraseña para almacenamiento seguro.
     * 4. Asigna automáticamente el rol 'USER' al nuevo registro.
     * </p>
     *
     * @param dto Datos capturados desde el formulario de registro.
     * @return El objeto {@link Usuario} ya persistido.
     * @throws RuntimeException Si el usuario/email ya existe o si el rol por defecto no se encuentra.
     */
    @Override
    @Transactional
    public Usuario registrar(UsuarioRegistroDto dto) {
        if (usuarioRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("El nombre de usuario '" + dto.getUsername() + "' ya está registrado.");
        }

        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("El correo electrónico ya está en uso.");
        }
        
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setNombre(dto.getNombre());
        usuario.setApellidos(dto.getApellidos());
        
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setEnabled(true);
        
        Rol rolUser = rolService.findById("USER")
                .orElseThrow(() -> new RuntimeException("Error crítico: El rol USER no existe en la base de datos."));

        usuario.getRoles().add(rolUser);

        return usuarioRepository.save(usuario);
    }

    /**
     * Busca un usuario por su identificador numérico.
     */
    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Busca un usuario por su nombre de acceso (username).
     */
    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}