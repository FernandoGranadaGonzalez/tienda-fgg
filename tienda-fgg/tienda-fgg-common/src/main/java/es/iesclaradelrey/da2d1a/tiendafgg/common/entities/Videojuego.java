package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un Videojuego en el catálogo de la tienda.
 * <p>
 * Esta clase centraliza la información del producto, incluyendo su precio,
 * descuentos y las relaciones con su marca fabricante y sus categorías.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "videojuegos")
public class Videojuego {

    /**
     * Identificador único del videojuego.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Código EAN-13 del producto.
     * Se almacena como String para preservar ceros a la izquierda.
     */
    @Column(nullable = false, length = 13)
    private String codigoEan;

    /**
     * Título comercial del videojuego.
     * Debe ser único para evitar duplicados en el catálogo.
     */
    @Column(unique = true, nullable = false, length = 200)
    private String titulo;

    /**
     * Relación muchos a uno con la entidad {@link Marca}.
     * <p>
     * Se utiliza {@code FetchType.LAZY} para mejorar el rendimiento, cargando la marca
     * solo cuando se acceda explícitamente a ella.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    /**
     * Relación muchos a muchos con la entidad {@link Categoria}.
     * <p>
     * Al ser una relación N:M, JPA crea una tabla intermedia llamada "videojuego_categoria"
     * para gestionar las asociaciones.
     * </p>
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "videojuego_categoria",
            joinColumns = @JoinColumn(name = "videojuego_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    /**
     * Descripción detallada del juego.
     * Soporta textos largos de hasta 4000 caracteres.
     */
    @Column(nullable = false, length = 4000)
    private String descripcion;

    /**
     * Precio de venta al público.
     * Validado para que nunca sea un valor negativo.
     */
    @Column(nullable = false)
    @PositiveOrZero(message = "El precio no puede ser negativo")
    private Double precio;

    /**
     * Porcentaje de descuento aplicado al producto (0-100).
     */
    @Column(nullable = false)
    @Min(value = 0, message = "El descuento no puede ser negativo")
    @Max(value = 100, message = "El descuento no puede ser mayor al 100%")
    private Integer descuento;

    /**
     * Nombre del archivo de imagen del videojuego.
     * Si no se especifica, se asigna un valor por defecto mediante el Builder.
     */
    @Builder.Default
    @Column(length = 500)
    private String imagen = "no-image.jpg";

    /**
     * Stock disponible del producto. Valor por defecto 10 a nivel de BD,
     * para que los INSERT existentes en data.sql no requieran cambios.
     */
    @Column(nullable = false, columnDefinition = "integer default 10")
    @Builder.Default
    private Integer stock = 10;
}