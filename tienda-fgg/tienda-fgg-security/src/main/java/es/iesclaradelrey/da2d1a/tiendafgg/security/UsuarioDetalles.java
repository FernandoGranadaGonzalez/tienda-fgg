package es.iesclaradelrey.da2d1a.tiendafgg.security;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Adaptador para integrar la entidad Usuario con el ecosistema de Spring Security.
 * <p>
 * Transforma los roles de la base de datos en GrantedAuthorities y proporciona
 * métodos adicionales para facilitar el acceso a la información del perfil
 * desde la capa de presentación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class UsuarioDetalles implements UserDetails {

    private final Usuario usuario;

    public UsuarioDetalles(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Expone la entidad original.
     * Útil para recuperar el ID o el Email en controladores mediante @AuthenticationPrincipal.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Mapea los roles de la entidad al formato estándar de Spring Security.
     * <p>
     * Se añade el prefijo "ROLE_" para ser compatible con anotaciones como
     * {@code @PreAuthorize("hasRole('ADMIN')")}.
     * </p>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getId()))
                .collect(Collectors.toList());
    }

    @Override public String getPassword()  { return usuario.getPassword(); }
    @Override public String getUsername()  { return usuario.getUsername(); }

    @Override public boolean isAccountNonExpired()    { return true; }
    @Override public boolean isAccountNonLocked()     { return true; }
    @Override public boolean isCredentialsNonExpired(){ return true; }

    /** Vincula el estado de habilitación con el campo 'enabled' de la BD. */
    @Override public boolean isEnabled()   { return usuario.isEnabled(); }

    /** Método de conveniencia para mostrar el nombre en la UI/Frontend. */
    public String getNombreCompleto() {
        return usuario.getNombre() + " " + usuario.getApellidos();
    }
}