package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.Data;
import java.util.Set;

/**
 * DTO (Data Transfer Object) integral para la representación de videojuegos.
 * <p>
 * Este objeto actúa como la entidad de transferencia principal en la API,
 * consolidando la información del producto junto con sus relaciones
 * normalizadas (Marca y Categorías).
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class VideojuegoDto {
    /** Identificador único persistente. */
    private Long    id;

    /** Código de barras internacional (European Article Number). */
    private String  codigoEan;

    /** Nombre comercial del videojuego. */
    private String  titulo;

    /** Reseña o explicación detallada del producto. */
    private String  descripcion;

    /** Precio de venta al público (antes de descuentos). */
    private Double  precio;

    /** Porcentaje de rebaja aplicado al precio original. */
    private Integer descuento;

    /** URL o nombre del recurso de imagen para la carátula. */
    private String  imagen;

    /**
     * Información del fabricante.
     * Implementado como objeto para evitar búsquedas adicionales del cliente.
     */
    private MarcaDto marca;

    /**
     * Conjunto de categorías a las que pertenece el juego.
     * Se usa un {@link Set} para garantizar la unicidad de las categorías asociadas.
     */
    private Set<CategoriaResumenDto> categorias;
}