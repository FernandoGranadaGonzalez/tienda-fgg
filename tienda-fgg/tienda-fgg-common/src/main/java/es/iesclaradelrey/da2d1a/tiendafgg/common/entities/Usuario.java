package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad principal de usuario para la gestión de acceso y perfil.
 * <p>
 * Implementa la persistencia de credenciales y datos personales, vinculando
 * al usuario con sus permisos mediante una tabla intermedia de roles.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Identificador único para el inicio de sesión. */
    @Column(unique = true, nullable = false)
    private String username;

    /** Hash de la contraseña (BCrypt). Nunca debe almacenarse en texto plano. */
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String apellidos;

    @Column(unique = true, nullable = false)
    private String email;

    private String telefono;
    private LocalDate fechaNacimiento;

    /** Fecha y hora exacta de la creación de la cuenta. */
    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    /** Indica si la cuenta está activa o ha sido suspendida. */
    private boolean enabled;

    /**
     * Colección de privilegios asignados.
     * <p>
     * Se utiliza FetchType.EAGER para asegurar que los roles estén disponibles
     * inmediatamente durante el proceso de autenticación de Spring Security.
     * </p>
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    @Builder.Default
    private Set<Rol> roles = new HashSet<>();

    /**
     * Hook de persistencia que automatiza la fecha de registro
     * en el momento de la inserción.
     */
    @PrePersist
    protected void onCreate() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
    }
}