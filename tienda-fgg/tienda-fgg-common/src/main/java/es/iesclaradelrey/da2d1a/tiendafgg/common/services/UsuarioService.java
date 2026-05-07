package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendafgg.common.dto.UsuarioRegistroDto;
import java.util.Optional;

/**
 * Interfaz que define los servicios de gestión de usuarios en la plataforma.
 * <p>
 * Expone las operaciones necesarias para la autenticación, la recuperación 
 * de perfiles y el proceso de alta de nuevos clientes.
 * </p>
 * 
 * @author Fernando Granada
 * @version 1.0
 */
public interface UsuarioService {

    /**
     * Localiza un usuario basado en su nombre de acceso.
     * <p>
     * Es el método principal utilizado por el motor de seguridad para 
     * verificar la identidad durante el login.
     * </p>
     * 
     * @param username El nombre de usuario único.
     * @return Un {@link Optional} con el usuario encontrado.
     */
    Optional<Usuario> findByUsername(String username);
    
    /**
     * Crea un nuevo usuario en el sistema a partir de los datos de registro.
     * <p>
     * Este método debe encargarse de validar la información, cifrar la 
     * contraseña y asignar los roles iniciales necesarios.
     * </p>
     * 
     * @param registroDto Objeto de transferencia con los datos del formulario.
     * @return El {@link Usuario} creado y persistido.
     */
    Usuario registrar(UsuarioRegistroDto registroDto);

    /**
     * Recupera la información de un usuario mediante su identificador interno.
     * 
     * @param id Identificador único numérico.
     * @return Un {@link Optional} con el usuario correspondiente.
     */
    Optional<Usuario> findById(Long id);
}