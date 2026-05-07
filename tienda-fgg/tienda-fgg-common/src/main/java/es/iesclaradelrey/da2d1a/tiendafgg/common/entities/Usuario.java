package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad que representa a los usuarios del sistema.
 * <p>
 * Almacena tanto la información de autenticación (credenciales) como los datos 
 * de perfil del usuario. Se vincula con la entidad {@link Rol} para gestionar 
 * los permisos de acceso mediante una relación de muchos a muchos.
 * </p>
 * 
 * @author Fernando Granada
 * @version 1.0
 */
@Entity
@Table(name = "usuarios")
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class Usuario {

    /**
     * Identificador único autoincremental del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de usuario único para el inicio de sesión.
     */
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * Contraseña cifrada del usuario.
     * Se define una longitud de 100 para dar soporte a algoritmos de hashing como BCrypt.
     */
    @Column(nullable = false, length = 100)
    private String password;

    /**
     * Nombre de pila del usuario.
     */
    @Column(nullable = true)
    private String nombre;

    /**
     * Apellidos del usuario.
     */
    @Column(nullable = true)
    private String apellidos;

    /**
     * Dirección de correo electrónico única y obligatoria.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * Número de teléfono de contacto.
     */
    private String telefono;

    /**
     * Fecha de nacimiento para validaciones de edad o perfil.
     */
    private LocalDate fechaNacimiento;

    /**
     * Fecha y hora en la que el usuario se registró en la plataforma.
     */
    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    /**
     * Estado de la cuenta (activa o desactivada).
     * Utilizado por Spring Security para permitir o denegar el acceso.
     */
    private boolean enabled;

    /**
     * Conjunto de roles asignados al usuario.
     * <p>
     * Se utiliza {@code FetchType.EAGER} para cargar los permisos inmediatamente 
     * junto al usuario, facilitando la comprobación de autoridades en seguridad.
     * La relación se gestiona mediante la tabla intermedia {@code usuarios_roles}.
     * </p>
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    @Builder.Default
    private Set<Rol> roles = new HashSet<>();

    /**
     * Método de ciclo de vida que asegura la asignación de la fecha de registro
     * en el momento de la creación, si no ha sido establecida previamente.
     */
    @PrePersist
    protected void onCreate() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
    }
}