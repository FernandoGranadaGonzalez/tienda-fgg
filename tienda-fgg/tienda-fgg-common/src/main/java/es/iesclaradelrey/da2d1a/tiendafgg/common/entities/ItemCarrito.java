package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Entidad de persistencia que representa una entrada individual en el carrito de compra.
 * <p>
 * En lugar de un modelo de cabecera-detalle, este sistema utiliza un enfoque
 * de ítems independientes vinculados a un usuario. La integridad se mantiene
 * mediante una restricción única que impide que un usuario tenga el mismo
 * videojuego en múltiples filas.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Entity
@Table(
        name = "items_carrito",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_item_carrito_usuario_producto",
                columnNames = {"usuario_id", "videojuego_id"}
        )
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ItemCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Usuario propietario de este ítem.
     * Carga Lazy para optimizar el rendimiento al recuperar listas de ítems.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    /**
     * Producto añadido al carrito.
     * La relación es obligatoria para garantizar la coherencia del catálogo.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "videojuego_id", nullable = false)
    private Videojuego videojuego;

    /** Cantidad de productos solicitada por el usuario. */
    @Column(nullable = false)
    private Integer unidades;

    /**
     * Marca de tiempo automática.
     * Permite conocer cuándo se modificó por última vez el interés del usuario.
     */
    @Column(nullable = false)
    private LocalDateTime fechaActualizacion;

    /**
     * Hook del ciclo de vida de JPA.
     * Asegura que la fecha de actualización sea siempre precisa
     * sin intervención manual del desarrollador.
     */
    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }
}