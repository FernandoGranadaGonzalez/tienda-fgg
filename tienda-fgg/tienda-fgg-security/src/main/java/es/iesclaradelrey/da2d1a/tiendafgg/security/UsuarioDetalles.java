package es.iesclaradelrey.da2d1a.tiendafgg.security;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Adaptador para integrar la entidad Usuario con Spring Security.
 * <p>
 * Implementa {@link UserDetails} para proporcionar la información de 
 * autenticación y autorización necesaria al framework de seguridad.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class UsuarioDetalles implements UserDetails {

    private final Usuario usuario;

    /**
     * Envuelve una instancia de la entidad Usuario.
     *
     * @param usuario La entidad de base de datos.
     */
    public UsuarioDetalles(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Transforma los roles de la entidad en autoridades de Spring Security.
     * <p>
     * Se añade el prefijo "ROLE_" a cada identificador de rol, siguiendo
     * la convención estándar para el uso de {@code hasRole()} en las vistas y controladores.
     * </p>
     *
     * @return Colección de autoridades otorgadas.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }
    
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }

    /**
     * Indica si el usuario está habilitado basándose en el campo de la base de datos.
     */
    @Override
    public boolean isEnabled() {
        return usuario.isEnabled();
    }

    /**
     * Helper para obtener el nombre legible del usuario en la interfaz.
     *
     * @return Nombre completo o el nombre de usuario si el nombre es nulo.
     */
    public String getNombreCompleto() {
        if (usuario.getNombre() == null) return usuario.getUsername();
        return usuario.getNombre() + " " + (usuario.getApellidos() != null ? usuario.getApellidos() : "");
    }

    /**
     * Facilita el acceso al ID de la entidad para operaciones de perfil y rutas dinámicas.
     */
    public Long getId() {
        return usuario.getId();
    }
}