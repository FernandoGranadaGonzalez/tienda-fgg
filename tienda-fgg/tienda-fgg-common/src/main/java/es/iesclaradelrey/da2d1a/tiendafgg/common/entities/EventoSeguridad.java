package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Entidad que representa un registro de auditoría en el sistema de seguridad.
 * <p>
 * Se utiliza para persistir eventos relevantes como intentos de inicio de sesión,
 * cierres de sesión, registros de usuarios o accesos denegados, permitiendo
 * un seguimiento posterior de la actividad de los usuarios.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Entity
@Table(name = "eventos_seguridad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoSeguridad {

    /**
     * Identificador único autoincremental del evento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha y hora exacta en la que se produjo el evento.
     * Se gestiona automáticamente antes de la persistencia.
     */
    @Column(nullable = false)
    private LocalDateTime fechaHora;

    /**
     * Nombre de usuario asociado al evento.
     * Permite identificar quién intentó realizar la acción.
     */
    @Column(nullable = false)
    private String username;

    /**
     * Categoría del evento de seguridad.
     * Se almacena como un String en la base de datos para facilitar su lectura.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEvento tipoEvento;

    /**
     * Información adicional sobre el evento (ej: motivo del fallo, dirección IP, etc.).
     */
    private String detalles;

    /**
     * Método de ciclo de vida de JPA que se ejecuta antes de insertar el registro.
     * Garantiza que cada evento tenga una marca de tiempo precisa sin intervención manual.
     */
    @PrePersist
    protected void onCreate() {
        this.fechaHora = LocalDateTime.now();
    }
}