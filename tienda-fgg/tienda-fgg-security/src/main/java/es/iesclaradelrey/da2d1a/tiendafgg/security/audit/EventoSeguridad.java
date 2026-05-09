package es.iesclaradelrey.da2d1a.tiendafgg.security.audit;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Entidad de auditoría para el registro de eventos de seguridad.
 * <p>
 * Registra de forma persistente cualquier actividad crítica relacionada con
 * el control de acceso, permitiendo realizar análisis forenses y detección
 * de intrusiones o patrones de ataque (fuerza bruta, etc.).
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Entity
@Table(name = "eventos_seguridad")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class EventoSeguridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Marca temporal del suceso.
     * Crucial para reconstruir la línea de tiempo de un incidente.
     */
    @Column(nullable = false)
    private LocalDateTime fechaHora;

    /**
     * Identidad asociada al evento.
     * En fallos de login, almacena el texto introducido por el atacante.
     */
    @Column(nullable = false)
    private String username;

    /**
     * Tipo de acción realizada.
     * Almacenado como String para mantener la legibilidad en herramientas SQL.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TipoEvento tipoEvento;

    /**
     * Dirección IP del cliente.
     * Permite identificar geográficamente ataques o bloqueos por origen.
     */
    @Column(length = 50)
    private String ipOrigen;

    /**
     * Información contextual adicional.
     * Ejemplo: "Bad credentials", "Token expired" o el User-Agent del navegador.
     */
    @Column(length = 255)
    private String detalle;
}