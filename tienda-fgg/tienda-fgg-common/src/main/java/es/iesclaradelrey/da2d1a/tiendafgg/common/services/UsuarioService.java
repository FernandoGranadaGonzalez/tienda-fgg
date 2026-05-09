package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendafgg.common.dto.UsuarioRegistroDto;

import java.util.Optional;

/**
 * Interfaz de servicio para la gestión de usuarios y seguridad.
 * <p>
 * Define las operaciones necesarias para localizar usuarios en los procesos
 * de autenticación y para la creación de nuevas cuentas en el sistema.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface UsuarioService {

    /**
     * Recupera un usuario por su nombre de cuenta único.
     * <p>
     * Utilizado principalmente por el motor de seguridad para cargar
     * los detalles del usuario durante el login o la validación de tokens.
     * </p>
     *
     * @param username Nombre de usuario a buscar.
     * @return Un {@link Optional} que contiene al usuario si existe.
     */
    Optional<Usuario> findByUsername(String username);

    /**
     * Localiza a un usuario mediante su clave primaria.
     *
     * @param id Identificador único numérico.
     * @return Un {@link Optional} con el usuario encontrado.
     */
    Optional<Usuario> findById(Long id);

    /**
     * Orquesta el proceso de registro de un nuevo usuario en la plataforma.
     * <p>
     * La implementación debe encargarse de:
     * <ul>
     *     <li>Validar que el username/email no existan previamente.</li>
     *     <li>Codificar la contraseña usando un PasswordEncoder.</li>
     *     <li>Asignar los roles por defecto (habitualmente "USER").</li>
     * </ul>
     * </p>
     *
     * @param registroDto Objeto con los datos de entrada validados.
     * @return El usuario recién creado y persistido.
     */
    Usuario registrar(UsuarioRegistroDto registroDto);
}